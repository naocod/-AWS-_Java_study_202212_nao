package j21_예외;

public class ArratException {
	
	public static void main(String[] args) {
		
		Integer[] nums = {1, 2, 3, 4, 5};
		
		try {
			throw new NullPointerException(); // 강제로 예외 발생
//			for(int i = 0; i < 6; i++) {
//				System.out.println(nums[i]);
//			}
		}catch (IndexOutOfBoundsException e) { 
			System.out.println("예외 처리"); // if문과 같이 오류가 나면 catch문이 실행됨
			// 상위에 Exception 클래스가 있어 업캐스팅되어 처리됨
		}catch (NullPointerException e) {
			System.out.println("빈값 처리함");
		}catch (Exception e) { // 모든 예외를 포함함
			System.out.println("예상 못한 예외 처리함"); // 작성된 오류 외의 오류 경우를 잡아줘야 프로그램이 다운되지 않음
		}
		
		System.out.println("프로그램 정상 종료");
	}

}
