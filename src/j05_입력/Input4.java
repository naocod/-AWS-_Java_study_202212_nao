package j05_입력;

import java.util.Scanner;

public class Input4 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int a = 0;
		int b = 0;
		int c = 0;
		
		int max = 0;
		int min = 0;
		
		System.out.print("정수 3개 입력: "); // 버퍼 열리고
		a = scanner.nextInt(); // 스페이스나 엔터를 구분으로 받음
		b = scanner.nextInt();
		c = scanner.nextInt();
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		
//		max = a > b && a > c ? a
//				: b > a && b > c ? b
//				: c ;
		
//		min = b > a && c > a ? a
//				: a > b && c > b ? b
//				: c;
				
		max = a;
		max = b > max ? b : max;
		max = c > max ? c : max;
		
		min = a;
		min = b < min ? b : min;
		min = c < min ? c : min;
				
				
				
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
		
	}

}

