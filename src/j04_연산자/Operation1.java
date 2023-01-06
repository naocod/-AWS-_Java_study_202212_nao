package j04_연산자;

public class Operation1 {
	public static void main(String[] args) {
		int add = 1 + 2;
		int sub = 10 - 5;
		int mul = 10 * 2;
		int div = 10 / 5;
		int remainder = 10 % 5;
		
		System.out.println(add);
		System.out.println(sub);
		System.out.println(mul);
		System.out.println(div);
		System.out.println(remainder);
		
		//삼항 연산자
		System.out.println(remainder == 0 ? "5의 배수이다" : "5의 배수가 아니다"); // 하나의 연산이 이루어짐
	}
}
