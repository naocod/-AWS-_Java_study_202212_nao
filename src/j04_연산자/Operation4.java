package j04_연산자;

public class Operation4 {
	public static void main(String[] args) {
		int num = 100;
		
		num = num + 1;
		
		num += num; // 자기 자신에게 연산을 할 때 사용함
		
		System.out.println(num);
	}
}
