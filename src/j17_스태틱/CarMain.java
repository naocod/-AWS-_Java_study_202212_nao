package j17_스태틱;

public class CarMain {
	
	public static void main(String[] args) {
		Car[] cars = new Car[5];
		
		cars[0] = new Car("k3");
		cars[1] = new Car("k5");
		cars[2] = new Car("k7");
		cars[3] = new Car("k9");
		cars[4] = new Car("제네시스");
		
		for(Car c : cars) {
			System.out.println(c);
		}
		
	}

}
