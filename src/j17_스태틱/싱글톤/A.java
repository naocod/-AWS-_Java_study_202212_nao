package j17_스태틱.싱글톤;

public class A {
	
	private static A instance = null; // 싱글톤 만드는 법 1. A클래스 자체를 리턴할 수 있는 instance
	
	private Student[] students;
	
	private A() {
		students = new Student[3];
	}
	
	public static A getInstance() { // 2.instance를 return해주는 getInstance
		if(instance == null) {
			instance = new A();
		}
		return instance;
	}
	
	public void addStudent(Student student) {
		
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) {
				students[i] = student;
				return; // return을 만나면 메소드를 탈출함 > void라서 return에 아무값도 없으면 탈출가능한 것.
				// 만약에 break면 아래의 출력문이 실행되어버림
			}
		}
		
		System.out.println("더 이상 학생을 추가할 수 없습니다.");
		System.out.println();
	}
	
	public void showStudents() {
		for(Student student : students) {
			System.out.println(student); // 만약 .toString을 찍는다면 null일 경우 null.toString이 되어 nullPointException 오류가 일어나게됨
		}
		System.out.println();
	}

}
