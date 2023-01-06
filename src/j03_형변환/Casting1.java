package j03_형변환;

public class Casting1 {

	public static void main(String[] args) {
		char a = 'a';
		int num1 = a; // 정수 변수에 char(문자) 
		
		System.out.println(a); 
		System.out.println((double)a); // 문자 > 숫자로 실질적인 형변환 / 내가 바꾸고자하는 자료형을 명시함
		System.out.println((char) 97.0);
		System.out.println((byte) 300); // byte의 값이 300을 나타낼 수 없어 44로 표현됨
	}

}
