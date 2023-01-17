package usermanagement.repository;

import java.util.ArrayList;
import java.util.List;

import usermanagement.entity.User;

public class UserReoisitory {

	private List<User> userDataList;
	
	private static UserReoisitory instance;
	
	public static UserReoisitory getInstance() {
		if(instance == null) {
			instance = new UserReoisitory();
		}
		return instance;
	}
	
	private UserReoisitory() {
		userDataList = new ArrayList<>();
	}
	
	public void saveUser(User user) {
		userDataList.add(user);
	}
	
	public User findUserByUsername(String username) {
		User user = null;
		
		for(User u : userDataList) {
			if(u.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		
		return user;
	}
	

}
