package j18_제네릭;

public class Main2 {
	
	// ? -> 와일드카드
	public CMRespDto<?> response(CMRespDto<?> cmRespDto) {
		// <? extends Person> -> Person을 포함해서 Person을 상속받은 객체만 받을 수 있음
		// <? super Student> -> Student를 기준으로 상위 객체만 가능
		/* 와일드카드에 대한 제약
		 * extends	대상 객체 하위
		 * super	대상 객체 상위
		 */
		System.out.println("[응답데이터]");
		System.out.println(cmRespDto);
		return cmRespDto;
	}
	
	public static void main(String[] args) {
		
		Main2 main = new Main2();
		// 객체가 생성되어야지만 멤버 메소드인 response를 호출할 수 있다.
		
		CMRespDto<?> hello 
			= new CMRespDto<String>(200, "성공", "안녕하세요");
		
		CMRespDto<?> score 
			= new CMRespDto<Integer>(200, "성공", 85);
		
//		CMRespDto<?> data = null;
		System.out.println("hello");
		System.out.println(main.response(hello)); // 와일드카드로 리턴되면 객체가 모호해짐 > Object로 형변환 된것과 같음
		
		System.out.println("data");
		System.out.println(main.response(score));
		
		// 안녕하세요.
	}

}
