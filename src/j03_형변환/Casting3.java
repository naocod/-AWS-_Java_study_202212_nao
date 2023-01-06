package j03_형변환;

public class Casting3 {

	public static void main(String[] args) {
		double kor = 87.5;
		double eng = 95.7;
		double math = 80.5;
		
		int total = 0;
		double avg = 0;	
		
		total = (int) kor + (int) eng + (int) math;
		avg = (double) total / 3.0;
//		avg = total / 3.0; // 자료형이 다르면 연산이 불가능하지만 int와 double이 연산하기 위해 int가 묵시적 형변환으로 double이 되어 double값으로 연산이 됨
		
		System.out.println("합계: " + total);
		System.out.println("평균: " + avg);
	}

}
