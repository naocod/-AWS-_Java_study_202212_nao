package j16_Object;

public class ObjectEquals {
	
	public static void main(String[] args) {
		String name1 = "김준일"; // 정해져있는 값 -> 리터럴
		String name2 = "김준일"; // byte 배열의 객체
		// 같은 주소가 들어감
		String name3 = new String("김준일"); // String은 클래스니까 원래는 new해서 생성해야하는데 이미 ..?
		// name2와 name3의 주소값이 다름
		
		System.out.println(name1);
		System.out.println(name2);
		
		System.out.println(name1 == name2); // 주소 비교
		System.out.println(name1 == name3);
		System.out.println(name1.equals(name3)); // 안에 있는 값을 비교 -> true
		
/////////////////////////////////////////////////////////////////////////////////
		
//		Student s1 = new Student("nao1", 20);
//		Student s2 = new Student("nao1", 20);
		// 생성을 따로 했기에 주소가 달라서 false
		
		Student s = new Student("nao1", 20);
		Student s1 = s;
		Student s2 = s;
		// 주소값이 같아서 true
		
		System.out.println(s1 == s2); // 주소값 비교
		
/////////////////////////////////////////////////////////////////////////////////

		Student t1 = new Student("nao", 20);
		Student t2 = new Student("nao", 21);
		
		System.out.println(t1.equals(t2)); // 매개변수에 대입되는 순간 업캐스팅(주소 변하지 않음)됨
		// 매개변수가 Object 타입으로 업캐스팅 되어 주소를 비교함(자기 자신과 매개변수를 비교) => false
		// => equals를 Override

/////////////////////////////////////////////////////////////////////////////////

		Student u1 = new Student("nao", 20);
		Student u2 = new Student("nao", 20);
		SubStudent u3 = new SubStudent("nao", 20);
		
		System.out.println(u1.equals(u3));
		
		
	}

}





























