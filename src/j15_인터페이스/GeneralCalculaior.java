package j15_인터페이스;

//확장은 하나
public class GeneralCalculaior extends Equipment implements Calculator{

	@Override
	public void powerOn() {
		System.out.println("일반 계산기 전원을 켭니다.");
	}
	
	@Override
	public void powerOff() {
		System.out.println("일반 계산기 전원을 켭니다.");
		
	}
	
	// 구현
	@Override
	public double plus(double x, double y) {
		System.out.println("일반 계산기에서 더하기 실행");
		return x + y;
	}

	@Override
	public double minus(double x, double y) {
		return x - y;
	}
	
	@Override
	public double division(double x, double y) {
		System.out.println("일반 계산기에서 나누기 실행");

		if(x == 0 || y == 0) {
			return ERROR;
		}
		return x / y;
	}
	
	


}
