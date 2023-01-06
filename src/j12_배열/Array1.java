package j12_배열;

public class Array1 {
	
	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;
		
		int[] nums = new int[5]; // 일반 자료형을 배열에 저장한 것이지 배열은 참조 자료형이다.
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		nums[3] = 40;
		nums[4] = 50;
		
		for(int i = 0; i < 5; i++) {
			System.out.println(nums[i]);
		}
		
	}

}
