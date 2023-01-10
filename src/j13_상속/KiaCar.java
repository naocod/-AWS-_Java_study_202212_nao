package j13_상속;

public class KiaCar extends Car {

		public KiaCar() {
			super(); // 부모, 상위 객체를 의미함 => super의 생성자 호출
			System.out.println("자식");
		}
		
//		public void test() {
//			KiaCar kc = this; // 변수에 본인의 주소값이 들어와야 할 경우
//		}
		
		@Override
		public int discountPrice(int percentage) {
			return super.discountPrice(percentage);
		}
		
}
