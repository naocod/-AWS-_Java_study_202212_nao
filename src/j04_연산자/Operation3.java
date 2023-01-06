package j04_연산자;

/*
 * 논리 연산자
 * 	- AND 연산자가 OR 연산자보다 우선 순위가 높음
 * 
 * AND(곱) T && T > T
 * 	- 하나라도 F(0)이면 F(0)
 * 
 * OR(합) T || F > T
 * 	- 하나라도 T(1)이면 T(1)
 * 
 * NOT(부정) !T > F
 *  - T이면 F를 F면 T를 도출함
 *  
 * 
 */
public class Operation3 {
	public static void main(String[] args) {
		int num = 11;
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = num % 2 == 0;
		
		System.out.println(flag1 && flag2);
		System.out.println(flag1 && flag3);
		System.out.println(flag2 || flag3 &&flag1);
		System.out.println(!(flag2 || flag3 && flag1));
	}
}
