package j16_Object;

import java.util.Objects;

public class Student extends Object{
	private String name;
	private int age;
	
	
	public Student(String name, int age) {
		super(); // 부모클래스의 생성자 호출
		// => Object 클래스의 생성자 호출
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, age); // 조합을 해서 하나의 해시코드로 출력
		// 매개변수를 통해 값을 받아서 코드 조합 (해시코드)를 만들어서 리턴
		// 주소가 달라도 값이 같으면 해시코드의 값이 같고 매개변수 값이 다르면 해시코드 값이 다르다
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true; // 똑같은 주소값은 똑같은 값이 들어가있음
		}
		
		if(obj == null) {
			return false;
		}
		
		if(!(obj.getClass() == Student.class)) { 
			return false;
		}
		
		// 주소가 다르고 null이 아닐때 실행
		
		Student s = (Student) obj;
		// object가 가지고 있는 name을 비교하기 위해서 다운캐스팅 해줘야함
		boolean result = name.equals(s.name) && age == s.age;
		
		return result;
	}

	@Override
	public String toString() { // Object 클래스의 toString을 Override(재정의)
		return "이름: " + name + "\n나이: " + age; 
	}
	
	
}
