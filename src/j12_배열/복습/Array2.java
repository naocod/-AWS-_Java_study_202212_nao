package j12_배열.복습;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class User { 
	private String username;
	private String password;
}


public class Array2 {
	
	public static void main(String[] args) {
		
		// User 객체 생성
		User user1 = new User("aaa", "1234");
		User user2 = new User("bbb", "2222");
		User user3 = new User("ccc", "3333");
		
//		User[] users = new User[3];
//		users[0] = new User("aaa", "1234");
//		users[1] = new User("bbb", "2222");
//		users[2] = new User("ccc", "3333");
		
		// User 객체를 담을 수 있는 배열 생성
		User[] users = new User[] {
				new User("aaa", "1234"), 
				new User("bbb", "2222"), 
				new User("ccc", "3333")};
		
//		Integer[] integers = new Integer[] {new Integer(10), new Integer(20), new Integer(30)};
		Integer[] integers = new Integer[] {10, 20, 30};
		// 리터럴에 대한 문제
		
		List<Integer> integerList = Arrays.asList(integers);
		System.out.println("출력 >>> " + integerList);
	
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user3);
		
		for(int i = 0; i < users.length; i++) {
			System.out.println(users[i].getUsername());
		}
		
		for(User u : users) {
			System.out.println(u);
		}
		
		List<User> userList = Arrays.asList(users);
		System.out.println(userList);
		
	}

}
