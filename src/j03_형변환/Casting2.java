package j03_형변환;

public class Casting2 {

	public static void main(String[] args) {
		char char_a = 'a';
		int num = (int) char_a; // char 자료형인 char_a를 int 자료형으로 형변환 하여 num에 대입함
		// 상위의 자료형으로 형변환 > 업캐스팅
	
		char char_b = (char) (num + 1); // int 변수인 num을 char에 대입하기 위해 하위 자료형으로 형변환 > 다운캐스팅
		// num을 char로 형 변환 한 뒤에 상수를 더하여 오류가 생기므로 우선순위에 근거하여 num + 1을 괄호로 묶어 같이 다운캐스팅이 이루어져야함
		System.out.println(char_b);
	}

}
