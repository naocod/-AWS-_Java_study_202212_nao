package j12_배열.di;

public class Main {
	
	public static void main(String[] args) {
		Test_C tc = new Test_C();
		Test_C tc2 = new Test_C();
		
		Test_B tb = new Test_B(tc); // dependency Injection(DI) 객체지향의 필수요소
		
		Test_A ta = new Test_A(tb);
		// A를 생성하려면 B가, B를 생성하려면 C가 필요함
		
//		ta.setTb(tb);
		
		ta.testA1();
		ta.testA2();
	}

}
