package j19_컬렉션;

import java.util.HashSet;
import java.util.Set;

public class StudentHashSet {
	
	private static Student searchStudent(Set<Student> students, String searchName) {
		Student student = null;
		
		for(Student s : students) {
			if(s.getName().equals(searchName)) {
				student = s;
				break;
			}
		}
		
		return student;
	}
	
	public static void main(String[] args) {
		Set<Student> students = new HashSet<>();
		
		students.add(new Student("nao1", 26));
		students.add(new Student("nao2", 24));
		students.add(new Student("nao3", 29));
		students.add(new Student("nao4", 21));
		
		System.out.println(students);
		
		Student student = searchStudent(students, "nao1");
		
		if(student == null) {
			System.out.println("검색 실패");
		}else {
			System.out.println("검색 성공" + student);
		}
	}

}
