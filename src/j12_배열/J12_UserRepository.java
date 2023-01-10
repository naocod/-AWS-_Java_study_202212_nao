package j12_배열;

//저장소
// 응집도가 높음
public class J12_UserRepository {
	
	private J12_User[] userTable;

	public J12_UserRepository(J12_User[] userTable) { // 결합도가 낮을 프로그래밍 >> 배열을 안에서 정의만 하고 만들진 않았음
		this.userTable = userTable; // 배열을 외부로부터 받아서 배열을 사용함. >> 배열 > 하나의 부품
	}
	
	// 전체 사용자 리턴
	public J12_User[] getUserTable() {
		return userTable;
	}
	
	public void saveUser(J12_User user) {
		extendArrayOne();
		userTable[userTable.length - 1] = user;
		
	}
	
	private void extendArray(int length) { // 배열 확장
		J12_User[] newArray = new J12_User[userTable.length + length];
		transferDataToNewArray(userTable, newArray); // userTable의 데이터를 newArray에 다 옮겨라.
		userTable = newArray;
	}

	private void extendArrayOne() { 
		J12_User[] newArray = new J12_User[userTable.length + 1];
		transferDataToNewArray(userTable, newArray); // userTable의 데이터를 newArray에 다 옮겨라.
		userTable = newArray;
	}
	
	private void transferDataToNewArray(J12_User[] oldArray, J12_User[] newArray) {
		for(int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}
	
	public J12_User findUserByUsername(String username) {
		
		J12_User user = null;
		
		for(J12_User u : userTable) {
			if(u == null) {
				continue;
			}
			if(u.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		return user;
	}

	/*
	 *
	 * 1. 사용자이름으로 회원 조회
	 * 
	 * 2. 회원 정보 수정
	 * 		수정 할 사용자이름을 입력하세요: aaa
	 * 
	 * 		해당 사용자이름은 존재하지 않는 사용자이름입니다.
	 * 
	 * 		========<< 수정메뉴 >>========
	 * 		사용자이름: aaa
	 * 		==============================
	 * 		1. 비밀번호 변경
	 * 		2. 이름 변경
	 * 		3. 이메일 변경
	 * 		==============================
	 * 		b. 뒤로가기
	 * 
	 * 		수정 메뉴 선택: 1
	 * 
	 * 
	 * 		========<< 비밀번호 변경 >>========
	 * 		기존의 비밀번호를 입력하세요: 1234
	 * 
	 * 		[비밀번호가 틀리면] 비밀번호가 일치하지 않습니다.(수정 메뉴로 이동)
	 * 		[비밀번호가 일치하면]
	 * 		새로운 비밀번호를 입력하세요: 1111
	 * 		새로운 비밀번호를 확인해주세요: 1234
	 * 
	 * 		[비밀번호가 틀리면] 비밀번호 서로 일치하지 않습니다.(수정 메뉴로 이동)
	 * 		[비밀번호가 일치하면]
	 * 		비밀번호 변경 완료.
	 * 		
	 */


}
