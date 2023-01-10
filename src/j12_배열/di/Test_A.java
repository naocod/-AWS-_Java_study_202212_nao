package j12_배열.di;

public class Test_A {
	
//	private Test_B tb = new Test_B(); // 컴파일과 동시에 생성을 안했지만 생성이 되고있음>메모리 할당 (컴파일을 하면 정의를 해야함)
	
	private Test_B tb; // final로 잡으면 무조건 대입(초기화)가 한번은 이루어져야 함
	// setter르러 사용하려면 final 해제
	 
	public Test_A(Test_B tb) { // Test_A가 생성되어야지만 tb 생성 > 의존도가 높음 = 결합도가 높음 >> 의존관계, 의존성(Dependency)
//		tb = new Test_B();
		this.tb = tb; // 1. 생성자의 매개변수를 통해서 주는것 
	}
	// 필수 매개변수를 가지는 
	// 기본 생성자 > NoArgument Constructor
	// 전체 생성자 > AllArgument Constructor
	
//	public void setTb(Test_B tb) { // tb값을 final로 잡고 setter를 사용하면 계속 값을 변경해야하기 때문에 사용하지 못함
//		this.tb = tb; // 2. setter를 통해 받음
//		// tb를 생성하지 않고 사용하면 NullPointerExeption 오류 발생
//	}
	
	public void testA1() {
		System.out.println("테스트A1 메소드 호출!");
//		Test_B tb = new Test_B();
		
		tb.testB1();
	}
	
	public void testA2() {
		System.out.println("테스트A2 메소드 호출!");
//		Test_B tb = new Test_B();
		
		tb.testB1();
	}
}
