package j15_인터페이스;

public class Main {
	
	public static void main(String[] args) {
		
		Equipment[] equipments = new Equipment[2];
		
		equipments[0] = new GeneralCalculaior(); // Equipment를 담을 수 있는 배열에 GeneralCalculaior와 SmartPhone 생성
		equipments[1] = new SmartPhone();
		
		Calculator calculator = new Computer();
		
		System.out.println("모든 장비 전원 켜기");
		for(Equipment eq : equipments) {
			eq.powerOn();
		}
		System.out.println();
		// SmartPhone가 Equipment와 Calculator가 될 수 있음
		// Calculator가 Equipment가 되는것은 아님
		
		System.out.println("모든 장비에서 10과 20을 더하기");
		for(Equipment eq : equipments) {
			Calculator c = (Calculator) eq; // eq를 Calculator로 다운캐스팅 -> SmartPhone 객체가 Equipment(장비)로 업캐스팅 되어있는 것을 Calculator로 바꿔 계산기 기능을 사용
			double result = c.plus(10, 20);
			System.out.println("결과: " + result);
		}
		
		System.out.println();
		
		System.out.println("모든 장비에서 10과 0을 나누기");
		for(Equipment eq : equipments) {
			Calculator c = (Calculator) eq; 
			double result = c.division(10, 0);
			System.out.println("결과: " + result);
		}
		
		System.out.println();
		
		System.out.println("모든 장비 전원 끄기");
		for(Equipment eq : equipments) {
			eq.powerOff();
		}
		System.out.println();
		
	}

}
