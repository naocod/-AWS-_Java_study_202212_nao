package j18_제네릭;

public class Main {
	
	public static void main(String[] args) {
		TestData<String, Integer> td = new TestData<String, Integer>("nao", 100);
		//  변수							생성될때 제네릭 타입을 Integer를 잡아주면 TestData 클래스의 T자리에 Integer를 넣어서 생성하게됨
		// 생성하고나서는 못 바꿈
		TestData<String, Double> td2 = new TestData<String, Double>("nao2", 100.05);
		System.out.println(td);
		System.out.println(td2);
	}

}
