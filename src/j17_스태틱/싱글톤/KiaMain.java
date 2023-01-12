package j17_스태틱.싱글톤;

public class KiaMain {
	
	public static void main(String[] args) {
		KIA kia = KIA.getInstance(); // 유일하게 하나 존재해야하는 
		// 하나의 객체만 만들어서 이를 통해서만 메소드를 실행하고 공유해야하는 경우
//		KIA kia2 = new KIA(); // 안됨
		
		kia.printCompanyName(); // static 없는 일반메소드 > 주소가 있기 때문에 호출가능
	}

}
