package j17_스태틱;

import java.time.LocalDateTime;

public class Car {
	
	private static final int NOW_YEAR = LocalDateTime.now().getYear(); // 클래스명. 다음은 스태틱.
	
	private static final String CODE = "KIA-" + NOW_YEAR + "-";
	private static int ai = 1;

	private String serialCode;	// KIA-2023-0000
	private String modelName;
	

	public Car(String modelName) { // 생성자
		serialCode = CODE + String.format("%04d", ai);
		ai++;
		this.modelName = modelName;
	}


	@Override
	public String toString() {
		return "Car [serialCode=" + serialCode + ", modelName=" + modelName + "]";
	}
	

}
