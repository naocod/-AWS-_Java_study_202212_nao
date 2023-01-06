package j12_배열;

public class Array5 {
	
	//배열이 존재하고 있는 주소값을 줬기에 아래 addArrayLength에 쓰이는 배열과 같은 걸 사용하기에 return을 줄 필요가 없음
	public static void transferArray(int[] oldArray, int[] newArray) {
		for(int i = 0; i < oldArray.length; i++) { // 7. 기존 배열의 크기(0)만큼 돌아감 > 실행안됨
			newArray[i] = oldArray[i]; // 새로운 데이터 배열에 기존 배열의 데이터를 대입함
		}
	}

	public static int[] addArrayLength(int[] array) { // 4. 빈 배열 들어옴
		int[] newArray = new int[array.length + 1]; // 기존 배열에서 배열의 크기 증가 5. 비어있는 배열에 새로운 공간이 만들어짐 [0]
		transferArray(array, newArray); // 6. array > 아무것도 없는 배열, newArry > [0] 새로운 공간이 만들어진 배열
		return newArray; // 새로운 배열 리턴
	}
	
	public static int[] addData(int[] array, int data) { // 2. addData 메소드에 nums 배열을 전달함(비어있음) 그 후 28~32와 같이 기존 배열에 값 대입
		int[] newArray = addArrayLength(array); // 3. newArray 배열 생성하여 addArrayLength를 전달함.
		newArray[array.length] = data; // newArray의 array.length > 0
		return newArray; // 8. newArray 리턴 > [0]
	}
	
	public static void main(String[] args) {
		
		int[] nums = new int[0]; // 1. 비어있는 배열 생성
		
		nums = addData(nums, 1);
		nums = addData(nums, 2);
		nums = addData(nums, 3);
		nums = addData(nums, 4);
		nums = addData(nums, 5);
		
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
//		nums = addArrayLength(nums);
	}
}
