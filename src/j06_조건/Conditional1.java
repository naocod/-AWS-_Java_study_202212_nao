package j06_조건;

public class Conditional1 {
	
	public static void main(String[] args) {
		
		int num = 5;
		int num2 = 5;
		
		if(num > num2) {
			System.out.println("num이 num2보다 큽니다.");
			System.out.println("num: " + num);
		} else {
			if(num == num2) {
				System.out.println("num과 num2가 같습니다.");
			} else /*(num < num2)*/ {
				System.out.println("num이 num2보다 작습니다.");
			}
		}
		
	}
}
