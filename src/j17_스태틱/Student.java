package j17_스태틱;

public class Student {
	
	private static final int CODE = 20230000;
	private static int ai = 1; // auto_increment
	
	private int studentCode;
	private String name;
	
	public Student(String name) {
		studentCode = CODE + ai;
		ai++;
		this.name = name;
	}
	
	public static int getAutoIncrement() {
		System.out.println("현재 AI: " + ai); // 생성이 되지 않아도 호출할 수 있는 변수
//		System.out.println("학생이름: " + name); // 메모리에 할당 될 때(생성이 되어야지)만 사용할 수 있는 변수 
		return ai;
	}

	@Override
	public String toString() { // 객체 표현
		return "Student [studentCode=" + studentCode + ", name=" + name + "]";
	}
	
	
	

}
