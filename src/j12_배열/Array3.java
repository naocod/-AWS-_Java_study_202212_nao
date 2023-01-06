package j12_배열;

import java.util.Random;

public class Array3 {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		int[] nums = new int[10]; // 배열 생성 
		
//		for(int i = 0; i < nums.length; i++) {
//			nums[i] = random.nextInt(nums.length) + 1;					
//
//			for(int j = 0; j < i; j++) {
//				if(nums[i] == nums[j]) {
//					i--;
//				}
//			}
//		}
		
		
		for(int i = 0; i < nums.length; i++) {
			while(true) {
				boolean findFlag = true;
				
				int randomNum =  random.nextInt(nums.length) + 1;
				
				for(int j = 0; j < nums.length; j++) {
					if(nums[j] == randomNum ) {// 검색기법, 탐색기법
						findFlag = false;
						break;
					}
				}
				
				if(findFlag) {
					nums[i] = randomNum;
					break;
				}
			}
		}
		
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		

		
//		System.out.println(random.nextInt(10));
	}
}
