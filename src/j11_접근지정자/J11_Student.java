package j11_접근지정자;

public class J11_Student {
	
	private String name;
	private int age;
	

	
	public J11_Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	void printInfo() {  // 접근지정자를 생략할 경우 default
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}
}
