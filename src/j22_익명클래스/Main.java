package j22_익명클래스;

public class Main {
	
	public static void main(String[] args) {
		Calculator c1 = new Addition();
		
		System.out.println(c1.calc(10, 20));
		
//////////////////////////////////////////////////////////////////		
		
		Calculator c2 = new Calculator() { // 한번만 사용할 클래스인데 굳이 생성할 필요 없으며 낭비를 막기위해
			// 익명클래스(클래스 이름이 없음) 생성 -> 다른곳에서는 사용 못함(1회성)
			// 아래서 구현되었기에 생성가능
			@Override
			public int calc(int x, int y) { // 메소드 구현 -> 구현된 객체(클래스)
				return x - y;
			}
		};
		
		System.out.println(c2.calc(200, 100));
	}

}
