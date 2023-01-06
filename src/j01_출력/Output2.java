package j01_출력;

public class Output2 {

	public static void main(String[] args) {
		int year = 5;
		
		System.out.println("이름: 김준일");
		System.out.println("나이: " + (20 + year)); // 문자열로 붙어버려 -나이: 201- 출력 >> 괄호로 묶어 우선 순위를 높임
		System.out.println("이름: 김준이");
		System.out.println("나이: " + (21 + year));
		System.out.println("이름: 김준삼");
		System.out.println("나이: " + (22 + year));
		System.out.println("이름: 김준사");
		System.out.println("나이: " + (23 + year));

	}

}
