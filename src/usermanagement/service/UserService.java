package usermanagement.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.mindrot.jbcrypt.BCrypt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import usermanagement.entity.RoleDtl;
import usermanagement.entity.User;
import usermanagement.repository.UserRepoisitoryArrayList;
import usermanagement.repository.UserRepository;

public class UserService {
	
	private UserRepository userRepository;
	private Gson gson;
	
	private static UserService instance;
	
	public static UserService getInsance() {
		if(instance == null) {
			instance = new UserService();
		}
		return instance;
	}
	
	private UserService() {
		userRepository = UserRepository.getInstance();
		gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
	public Map<String, String> register(String userJson) {
		// response: 응답
		Map<String, String> response = new HashMap<>();
		
		Map<String, String> userMap = gson.fromJson(userJson, Map.class);
		// 필드값 하나하나는 변수이기에 map으로 바꿔야 반복을 돌릴 수 있음
		
		for(Entry<String, String> userEntry : userMap.entrySet()) { // map을 엔트리로 바꿔서 하나씩 꺼내서 Blank인지 확인하는 반복문
			
			if(userEntry.getValue().isBlank()) { // isBlank는 스페이스바도 공백으로 보고 isEmpty는 공백만..?
				response.put("error", userEntry.getKey() + "은(는) 공백일 수 없습니다.");
				return response;
			}
		}
			
		
		
		User user = gson.fromJson(userJson, User.class);
		System.out.println("서비스에 넘어옴! User 객체로 변환");
		System.out.println(user);
		
		if(duplicatedUsername(user.getUsername())) {
			response.put("error", "이미 사용중인 사용자 이름입니다.");
			return response;
		}

		if(duplicatedEmail(user.getEmail())) {
			response.put("error", "이미 가입된 이메일입니다.");
			return response;
		}
		
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		
		
		System.out.println("암호화 후");
		System.out.println(user);
		
		userRepository.saveUser(user);
		
		RoleDtl roleDtl = RoleDtl.builder()
						.roleId(3)
						.userId(user.getUserId())
						.build();
		
		userRepository.saveRoleDtl(roleDtl);
		
		response.put("ok", "회원가입 성공");
		
		return response;
	}
	
	private boolean duplicatedUsername(String username) {
		return userRepository.findUserByUsername(username) != null ;
	}

	private boolean duplicatedEmail(String email) {
		return userRepository.findUserByEmail(email) != null ;
	}
	
	public Map<String, String> authorize(String loginUserJson) {
		Map<String, String> loginUser = gson.fromJson(loginUserJson, Map.class);
		
		Map<String, String> response = new HashMap<>();
		
		for(Entry<String, String> entry : loginUser.entrySet()) {
			if(entry.getValue().isBlank()) {
				response.put("error", entry.getKey() + "은(는) 공백일 수 없습니다.");
				return response;
			}
		}
		
		String usernameAndEmail = loginUser.get("usernameAndEmail");
		
		User user = userRepository.findUserByUsername(usernameAndEmail);
		
		if(user == null) {
			user = userRepository.findUserByEmail(usernameAndEmail);
			if(user == null) {
				response.put("error", "사용자 정보를 확인해주세요.");
				return response;
			}
			
		}
		if(!BCrypt.checkpw(loginUser.get("password"), user.getPassword())) {
			response.put("error", "사용자 정보를 확인해주세요.");
			return response;
		}
		response.put("ok", user.getName() + "님 환영합니다.");
		return response;
	}

}
