package j10_생성자;

public class J10_StudentMain {
	
	public static void main(String[] args) {
		
		J10_Student s1 = new J10_Student("박성진", 29); // 생성자를 호출할 때 부터 값을 넣어줌. 이후부터는 .(참조)를 통해 데이터를 바꿈
		
		s1.printInfo(); // printInfo가 멤버변수를 출력함
		
	}

}
