package j12_배열.복습;



public class Array1 {
	
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;
		
//		int[] nums = new int[] {10, 20, 30, 40, 50}; // 사이즈 없이 입력도 가능
//		nums[0] = 10;
//		nums[1] = 20;
//		nums[2] = 30;
//		nums[3] = 40;
//		nums[4] = 50;
//		int[] nums = {10, 20, 30, 40, 50}; // 생략할 수 있는데 첫 입력에서 초기화 할 때만 사용가능
		
		System.out.println(new int[] {10, 20, 30, 40, 50}); // 이렇게 쓰면 배열의 주소가 나옴
		System.out.println((new int[] {10, 20, 30, 40, 50})[0]); // 배열의 0번 인덱스 출력
		System.out.println((new int[] {10, 20, 30, 40, 50})[1]); 
	}

}
