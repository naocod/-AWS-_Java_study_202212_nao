package j02_변수;

public class Variable3 {

	public static void main(String[] args) {
		/* 상수: 자료형 앞에 final이 붙는다.
		   한 번 초기화가 이루어지면 대입할 수 없음
		   상수 선언과 초기화가 동시에 이루어지거나 선언 후 최초의 초기화가 이루어질 경우만 가능
		   상수는 상수명을 무조건 대문자로 사용한다.
		*/
		
		final int age; // final(상수 - 변하지 않는 수)
		age = 30; // 대입에는 초기화 작업이 들어감
		System.out.println(age);
		
		final int NOW_AGE = 0; // 상수명을 대문자로 사용하기에 두 단어 이상은 구분하기 어려우므로 스네이크 표기법을 사용함
		System.out.println(NOW_AGE);
	}

}
