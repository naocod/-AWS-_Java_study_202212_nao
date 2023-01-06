package j12_배열;


// Entity 객체 - 정보를 담기 위한 객체
// Service 객체 - 기능을 담당하는 클래스>비지니스 로직 >> Main문
public class J12_User {
	
	private String username;	// 사용자 이름(아이디,  계정
	private String password;	// 비밀번호
	private String name;		// 성명
	private String email;		// 이메일
	
	public J12_User() {} // 기본생성자 > ctrl + space

	// alt + shift + s
	public J12_User(String username, String password, String name, String email) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() { // 해당 객체에 어떤 정보가 들어있는지 출력함
		return "J12_User [username=" + username + ", password=" + password + ", name=" + name + ", email=" + email
				+ "]";
	}
	
	
	
	
		
	

}
