package j16_Object;

class Test { // 임시 클래스. 내부 클래스는 아니고 별도로 존재하는 클래스 이지만 해당 클래스에서만 사용함
	private int num;
	
	public Test(int num) {
		super();
		this.num = num;
		System.out.println(num + "생성");
	}
	
	@Override
	protected void finalize() throws Throwable { // 가비지컬렉터가 실행되어 소멸이 되었을때 실행됨
		System.out.println(num + "객체 소멸");
	}
}

public class ObjectFinalize {
	
	public static void main(String[] args) {
		Test test = null;
		
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			test = new Test(i); // test변수에 담겼기때문에 쓰는 객체 
			
			test = null; // 혼자만 힙메모리에 존재하게 됨
			
			System.gc(); // Garbage Collector 실행. 우선순위 젤 아래
			// gc가 바로 실행되는것이 아니라 메모리 상황보고 JVM이 여유있을때 실행됨, 순서대로 실행되지 않음
			// Thread.sleep이 실행되면 아무것도 안하기 때문에 시간적 여유가 생겨 gc가 실행되고 순서대로 생성되고 소멸됨 
		}
		
	}

}
