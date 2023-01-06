package j11_접근지정자;

import j11_접근지정자.default1.J11_StudentDefault;

public class J11_StudentMain {
	
	public static void main(String[] args) {
		J11_Student s1 = new J11_Student(null, 0);
		s1.setName("김준일");
		
		s1.printInfo();
		
		J11_StudentDefault s2 = new J11_StudentDefault();
		
//		s2.name = "김준이"; //외부에서 변수에 직접 접근하여 값을 바꿈
		
		s2.setName("김준이");
		
//		System.out.println("이름: " + s2.name); // 직접 들어가서 직접 가져옴
		System.out.println("이름: " + s2.getName()); // getName 메소드를 통해서 가져옴 		
		
		
	}

}
