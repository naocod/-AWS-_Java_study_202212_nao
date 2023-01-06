package j10_생성자;

public class J10_Student {
	
	String name; // 클래스가 가지는 변수 > 참조 변수, 레퍼런스 변수, 멤버 변수라고 한다.
	int age;
	
	J10_Student() {
		System.out.println("기본 생성자 호출!");
	}
	
	J10_Student(int age) {
		System.out.println("학생의 나이: " + age);
	}

	J10_Student(String name) {
		System.out.println("학생의 이름: " + name);
	}

	J10_Student(String name, int age) {
		this.name = name; // this > 자기자신의 주소
		this.age = age;
	}
	
	void printInfo() {
		System.out.println("학생 이름: " + name); // 멤버 변수가 가지고 있는 데이터를 출력함
		System.out.println("학생 나이: " + age);
	}

}
