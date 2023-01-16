package j20_JSON.builder;

public class UserMain {
	
	public static void main(String[] args) {
		
//		User user = new User();
		User.UserBuilder userBuilder = new User.UserBuilder();
		
//		User user2 = User.builder().username("aaa").password("1234").build();
		// builder()가 UserBuilder 객체해서 리턴
		// username 메소드 호출해서 aaa값을 넘겨줌
		// User.builder().username("aaa") -> 여기까지 리턴 주소 값 같음
		
		User user2 = User.builder()
				.username("nao")
				.password("1234")
				.name("나오")
				.build();
		
		
		System.out.println(user2);
		
	}

}
