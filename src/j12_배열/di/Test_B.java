package j12_배열.di;

public class Test_B {
	
	private Test_C tc; // 멤버변수는 private
	
	public Test_B(Test_C tc) {
		this.tc = tc; // 외부로부터 받아옴
	} // Test_B가 
	
	public void testB1() {
		System.out.println("\t테스트B1 메소드 호출!");
		
		tc.testC1();
	}
}
