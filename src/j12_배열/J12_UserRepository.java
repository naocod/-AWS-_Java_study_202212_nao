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
	
	
	

}
