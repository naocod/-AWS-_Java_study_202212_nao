package j16_Object;

public class ObjectHashCode {
	
	public static void main(String[] args) {
		Student s1 = new Student("nao", 25);
		Student s2 = new Student("nao", 25);
		SubStudent s3 = new SubStudent("nao", 25);
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		System.out.println(s1.hashCode() == s2.hashCode()); // 해시코드가 같은 값을 가지는 객체
		// 주소가 아닌 데이터에 대한 해시코드의 조합
		System.out.println(s1.hashCode() == s3.hashCode());
		// 객체가 달라도 데이터가 같이 해시코드가 같으므로 다운캐스팅 필요 x
		
		
	}

}
