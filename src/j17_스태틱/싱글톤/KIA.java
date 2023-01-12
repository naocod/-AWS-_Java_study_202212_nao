package j17_스태틱.싱글톤;

public class KIA {
	
	private static KIA instance = null; // KIA 자료형의 static 변수
	// static 변수이기에 들어간 값 계속 유지, 자료형이 KIA 자기 자신, KIA 객체를 담음
	
	private KIA() {} // 생성자가 private이기때문에 바깥에서 호출할 수 없음
	// ex) 다른 클래스에서 KIA kia = new KIA(); 불가능
	
	public static KIA getInstance() { // instance 변수의 값을 꺼내는 getter
		if(instance == null) { // 특징. 비어있으면 
			instance = new KIA(); // 생성해서 넣는다. > 한번 생성하는 것이지 두번 생성하지 않음
			// 어느 누가 getInstance를 통해 생성(최초의 호출-> null -> 생성)하면 다른 곳에서 생성하지 않고 instance값 return해줌
		}
		return instance;
	}
	
	public void printCompanyName() {
		System.out.println(getClass().getSimpleName());
	}

}
