package j15_인터페이스;

// 인터페이스도 클래스
// 인터페이스는 abstract를 넣지 않아도 abstract가 생략되어있음
// 구현 객체를 사용할 수 없음 => 생성하는 용도가 아님
// 일반 변수(멤버 변수)를 가질 수 없음 근데 상수는 가질 수 있음
public interface Calculator {
	
	public int ERROR = -9999999; // 상수형은 final을 붙여줘야하는데 생략가능
	
	public double plus(double x, double y);
	
	public double minus(double x, double y);
	
	public default double multiplication(double x, double y) { // 일반 메소드를 사용하고 싶을 경우 default를 넣어준다.
		
		return x * y;
	}
	
	public double division(double x,  double y);
	
}
