package j13_상속.casting2;

public class Main {
	
	public static void main(String[] args) {
		Taxi taxi = new Taxi();
		Subway subway = new Subway();
		
		Transportation transportation = new Transportation();
		Taxi t1 = (Taxi) transportation;	//다운캐스팅
		
		// 업캐스팅으로 형변환되었을때 자신이 가지고 있는 것은 못쓰고 부모가 가진 것만 사용할 수 있음
		// 1. 다양하게 사용할 수 있기 때문
		Transportation transportation1 = taxi;
		Subway s1 = (Subway) transportation1; // 이거 안됨 자식 클래스인 Taxi로 다운캐스팅 했는데 Subway로 다운캐스팅 안됨
		
		Transportation transportation2 = subway;

		// 2. 배열로 묶을 수 있음
		Transportation[] transportations = new Transportation[6];
		
		// taxi랑 subway를 하나로 묶을 수 있음
		transportations[0] = taxi; 
		transportations[1] = subway; 
		transportations[2] = taxi; 
		transportations[3] = subway; 
		transportations[4] = taxi; 
		transportations[5] = subway; 
		
		// 그러면 반복을 돌릴 수 있음
		for(int i = 0; i < transportations.length; i++) {
			if(transportations[i] instanceof Taxi) { // instance 메모리에 할당된 객체
				Taxi tx = (Taxi) transportations[i];
			}else if(transportations[i] instanceof Subway) {
				Subway sw = (Subway) transportations[i];
				
			}
			
			
			
			transportations[i].go();
		}
		
		// for each
		for(Transportation t : transportations) {
			t.stop();
		}
		
	}

}
