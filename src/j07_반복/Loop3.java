package j07_반복;

import java.util.Scanner;

public class Loop3 {
	
	public static void main(String[] args) {
		 
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int total = 0;

		
		System.out.print("반복횟수: ");
		count = scanner.nextInt();
		System.out.println();
		
		for (int i = 0; i < count; i++) {
			int a = 0;
			int b = 0;
			
			System.out.println(i + 1 + "번 반복");
			System.out.print("a: ");
			a = scanner.nextInt();
			System.out.print("b: ");
			b = scanner.nextInt();
			
			total += a + b;
			
			System.out.println(i + 1 + "번 합: " + (a + b)); // 순서 상 정수의 합이기 때문에 i + 1은 괄호로 묶어주지 않음, 이스케이프문자는 문자열 자체에 엔터를 저장하고 싶을 때 사용함
			System.out.println();
		}
		
		System.out.println("총합: " + total);
	
		
	}

}
