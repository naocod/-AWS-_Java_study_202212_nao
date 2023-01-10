package j14_추상;

// 추상 메소드가 하나라도 있으면 추상 클래스로 정의해야함
// 1. 생성 불가능
public abstract class Transportation {
	
	// abstract: 추상 메소드
	public abstract void go(); // 중괄호없음 > 메소드가 호출되었을때 실행될 명령어가 없다 -> 구현되지 않았다.
	
	public abstract void stop();

}
