package j20_JSON.builder;

import lombok.Builder;
import lombok.Data;

@Data
//@AllArgsConstructor
@Builder
public class User {
	
	private String username;
	private String password;
	private String name;
	private String email;
	
	public static UserBuilder builder() {
		return new UserBuilder(); // static -> user를 생성하지 않아도 호출 가능
	}
	
	
//	public static class UserBuilder{ // User안에 들어있는 클래스
//		private String username;
//		private String password;
//		private String name;
//		private String email;
//		
////		public UserBuilder username(String username) {
////			this.username = username;
////			return this;
////		}
////		
////		public UserBuilder password(String password) {
////			this.password = password;
////			return this;
////		}
////		
////		public UserBuilder name(String name) {
////			this.name = name;
////			return this;
////		}
////		
////		public UserBuilder email(String email) {
////			this.email = email;
////			return this;
////		}
//		
//		public User build() { // 일반 메소드
//			return new User(username, password, name, email);
//		}
//		
//		// static안에 static은 생성안해도 사용 가능하지만 build는 일멘 메소드이기 때문에 생성해야지만 사용 가능
//	}

	

}
