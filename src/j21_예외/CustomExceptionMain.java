package j21_예외;

public class CustomExceptionMain {
	
	public static void main(String[] args) {
//		throw new IndexOutOfBoundsException("인덱스를 초과함");
		
		try {
			throw new CustomErrorException("뭔가 문제가 있음"); // 생성자 오버로딩을 해야됨
		} catch (CustomErrorException e) {
			String message = e.getMessage();
			System.out.println(message);
		}
		System.out.println("프로그램 종료");
	}

}
