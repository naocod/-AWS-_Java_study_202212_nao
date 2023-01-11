package j16_Object;

public class ToString {
	
	public static void main(String[] args) {
//		Object obj = new Object();
//		
//		System.out.println(obj);
//		
//		String str2 = obj;// Object 자료형을 String 변수에 담는 것은 말도 안되고 toString을 해줘야만 담을 수 있음
//		
//		String str = obj.toString();
//		
//		System.out.println(str);
		
		
		Student student1 = new Student("nao1", 30);
		Student student2 = new Student("nao2", 31);
		Student student3 = new Student("nao3", 32);
		Student student4 = new Student("nao4", 33);
		
		System.out.println(student1); // toString을 Override해서 값으로 사용가능
		System.out.println(student2); // toString이 단순히 주소를 보기 위한 것이 아니라 객체의 정보를 문자열로 바꿔서 보기 위함이다.
		System.out.println(student3);
		System.out.println(student4);
		
		String str = student1.toString(); // 주소를 println했을때는 toString이 나오지만 주소값이기에 String 변수에 넣을 수 없으므로 .toString 해줘야 함
		
		System.out.println(student1.toString()); // 단순 출력이라면 찍어줄 필요가 없지만 String 변수에 넣어야하는 경우가 생기기에 필요함 
		System.out.println(student2.toString()); // .toString을 찍지 않은 것과 결과값이 같음
		System.out.println(student3.toString());
		System.out.println(student4.toString());
		
		
	}

}
