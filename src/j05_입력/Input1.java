package j05_입력;

import java.util.Scanner;

public class Input1 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
//		int inputNum = scanner.nextInt();
//		System.out.println("입력값: " + inputNum);
		
		System.out.print("입력1: ");
		int a = scanner.nextInt();
		System.out.print("입력2: ");
		int b = scanner.nextInt();
		System.out.print("입력3: ");
		int c = scanner.nextInt();
		System.out.print("입력4: ");
		int d = scanner.nextInt();
		System.out.print("입력5: ");
		int e = scanner.nextInt();
		
		System.out.println("입력값: " + (a + b + c + d + e));
		
	}

}
