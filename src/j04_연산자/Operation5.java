package j04_연산자;

public class Operation5 {
	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 5;
		
	      int result = num1 > num2 ? num1 * -1 : num2 * -1;
	      
	      System.out.println(result);
	      
	      int num = 79;
	      
	      int result2 = num / 90 == 1 ? 90
	            : num / 80 == 1 ? 80 
	            : num / 70 == 1 ? 70 : 0;
	      
	      System.out.println(result2);
	      
	}
}
