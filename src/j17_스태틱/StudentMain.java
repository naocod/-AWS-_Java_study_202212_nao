package j17_스태틱;

public class StudentMain {
	
	public static void main(String[] args) {
		System.out.println(Student.getAutoIncrement());
		
		Student[] students = new Student[5];
		Teacher[] teachers = new Teacher[5];
		
		students[0] = new Student("nao1");
		students[1] = new Student("nao2");
		students[2] = new Student("nao3");
		students[3] = new Student("nao4");
		students[4] = new Student("nao5");
		
		teachers[0] = new Teacher("junil1");
		teachers[1] = new Teacher("junil2");
		teachers[2] = new Teacher("junil3");
		teachers[3] = new Teacher("junil4");
		teachers[4] = new Teacher("junil5");
		
		for(int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
			System.out.println(teachers[i]);
			System.out.println();
		}
		
		int j = 0;
		//  Student로 생성된 배열
		for(Student s : students) { // 배열 첫번째값을 s에 대입 ***
		//  변수 선언
			System.out.println(s);
			System.out.println(teachers[j]);
			j++; // j 변수 낭비
		}
		
		System.out.println();
		
//		for(Teacher t : teachers) {
//			System.out.println(t);
//		}
//		
		System.out.println(Student.getAutoIncrement());
		
		
	}

}
