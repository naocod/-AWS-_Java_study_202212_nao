package j19_컬렉션;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class User{
	private String username;
	private String name;
}


public class ArrayUserMain {
	
	public static void main(String[] args) {
		
		User[] userArray = {
				new User("aaa", "nao1"),
				new User("bbb", "nao2"),
				new User("ccc", "nao3"),
				new User("ddd", "nao4")
						
		};
		
		List<User> userList = Arrays.asList(userArray);
		
		String serchUsername = "aaa";
		
		/*
		 * 검색 성공! aaa계정의 회원 이름은 nao1입니다.
		 * 검식 실패! 존재하지 않는 계정입니다.
		 */
		
		User user = searchUser(userList, serchUsername);
		if(user == null) {
			System.out.println("검색 실패!");
			System.out.println("존재하지 않는 계정입니다.");
		} else {
			System.out.println("검색 성공");
			System.out.println( serchUsername + "계정의 회원 이름은" + user.getName() + "입니다.");
		}
		
//		boolean flag = true;
//		for(User user1 : userList) {
//			if(user1.getUsername().equals(serchUsername)) {
//				System.out.println("검색 성공! " + user1.getUsername() + "계정의 회원 이름은 " + user1.getName() + "입니다.");
//				flag = false;
//				break;
//			}
//		}
//		
//		if(flag) {
//			System.out.println("검색 실패! 존재하지 않는 계정입니다.");
//		}
		
	
	}
	
	private static User searchUser(List<User> userList, String username) { // userList와 serchUsername을 받음
		User user = null;
		
		for(User u : userList) {
			if(user.getUsername().equals(username)) { // userList의 user와 찾고자하는 username 비교
				user = u; // 비어있는 user변수에 대입> 주소를 넣어줌
				break; // 반복문을 빠져나옴
			}
		}
		
		return user; // user가 null이면 검색 실패, null이 아니면 검색 성공
		
	}

}






















