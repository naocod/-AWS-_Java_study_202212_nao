package j12_배열;

public class Array4 {
	
	public static void main(String[] args) {
		J12_User[] users = new J12_User[3];
		
		J12_User[] users2 = {
				new J12_User("aaa", "1234", "김종환", "aaa@gmail.com"),
				new J12_User("bbb", "1234", "이종현", "bbb@gmail.com"),
				new J12_User("ccc", "1234", "진채희", "ccc@gmail.com")		};
		
//		유저 객체를 담을 수 있는 공간 3개

		users[0] = new J12_User("aaa", "1234", "김종환", "aaa@gmail.com");
		users[0] = new J12_User("bbb", "1234", "이종현", "bbb@gmail.com");
		users[0] = new J12_User("ccc", "1234", "진채희", "ccc@gmail.com");
		
		for(int i = 0; i < users.length; i++)
//		sysout이 들어있음
			System.out.println(users[i].toString());
	
	
	}

}
