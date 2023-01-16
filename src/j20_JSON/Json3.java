package j20_JSON;

import com.google.gson.Gson;

public class Json3 {
	
	public static void main(String[] args) {
		
		Gson gson = new Gson(); // Gson 라이브러리를 사용하기 위해서 생성
		
//		System.out.println(Integer.valueOf("100") + 50); 
//		System.out.println(Integer.parseInt("100") + 50);
		
		gson.toJson(null);				// object	->	json
		gson.fromJson("", Object.class);// json		-> object
	}

}
