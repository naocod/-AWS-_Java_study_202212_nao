package j12_배열;

import java.util.Scanner;

public class J12_UserService {
	
	private Scanner scanner;
	// 위에 적으면 클래스가 생성되지않아도 생성되어 메모리를 할당받음
	public J12_UserService() {
		scanner = new Scanner(System.in); // 위에 적으면 클래스 틀을 만들때부터 대입하게 되어있고 생성자 안에서 대입하면 클래스가 생성되었을때 메모리를 할당받음 
	}
	
	public void run() {
		boolean loopFlag = true;
		char select = '\0';
		
		while(loopFlag) {
			showMainMenu();
			select = inputSelect("메인");
			loopFlag = mainMenu(select);
		}
	}
	
	public void stop() {
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println("프로그램 종료중...(" + (i + 1) + "/10)");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료");
	}

	public char inputSelect(String menuName) {
		System.out.print(menuName + "메뉴 선택: ");
		char select = scanner.next().charAt(0); // 입력받은 문자열의 0번 인덱스의 한글자를 받아서 char 자료형으로 리턴해줌
		scanner.nextLine();
		return select;
	}
	
	public void showMainMenu() {
		System.out.println("===========<< 메인메뉴 >>===========");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 등록");
		System.out.println("3. 사용자 이름으로 회원 조회");
		System.out.println("4. 회원 정보 수정");
		System.out.println("====================================");
		System.out.println("q. 프로그램 종료");
		System.out.println();
	}
	
	private boolean mainMenu(char select) {
		boolean flag = true;
		
		if(isExit(select)) {
			flag = false;
		}else {
			if(select == '1') {
				
			}else if (select == '2') {
				
			}else if (select == '3') {
				
			}else if (select == '4') {
				
			}else {
				System.out.println(getSelectedErrorMessage());
			}
		}
		System.out.println();
		
		return flag;
	}
	
	private boolean isExit(char select) {
		return select == 'q' || select == 'Q';
	}
	
	private String getSelectedErrorMessage() {
		return "###<< 잘못된 입력입니다. 다시 입력하세요. >>###";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
