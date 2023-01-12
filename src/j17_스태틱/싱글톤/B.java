package j17_스태틱.싱글톤;

import java.util.Scanner;

public class B {
	
	public void insertStudent() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학생 이름: ");
		String name = scanner.nextLine();
		
		Student student = new Student(name);
		A.getInstance().addStudent(student); // a변수를 만들지 않아도 그 자체로 객체이기 때문에 이렇게 사용
		A.getInstance().showStudents();
	}

}
