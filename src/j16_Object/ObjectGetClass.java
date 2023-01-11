package j16_Object;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectGetClass {
	
	public static void main(String[] args) {
		Student student = new Student("nao", 35);
		
		System.out.println(student.getClass()); // Student 클래스 만들어졌다고 하는 정보 출력
		System.out.println(Student.class); // Student 클래스 정보를 가져옴(생성x)
		
		System.out.println(student.getClass().getName());
		
//		System.out.println(student.getClass() == Student.class);
		
		Class studentClass = student.getClass();
		
//		studentClass.getName(); // student.getClass().getName() 과 같음
		
		String className = studentClass.getName();
		System.out.println("클래스 이름: " +  className);
		
		String simpleName = studentClass.getSimpleName();
		System.out.println("클래스 이름만: " + simpleName);
		
		Field[] fields = studentClass.getDeclaredFields();
		for(Field field : fields) {
			System.out.println(field + "/"); // field.toSting이 되어있음 
			//private java.lang.String j16_Object.Student.name/
			// 접지정자        자료형         클래스     변수
 			//private int j16_Object.Student.age/
		}
		
		System.out.println();
		
		Method[] methods = studentClass.getDeclaredMethods();
		for(Method method : methods) {
			System.out.println(method);
		}
	}

}
