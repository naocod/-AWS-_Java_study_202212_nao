package j20_JSON;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Json1 {
	
	public static void main(String[] args) {
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("a", "test1"); // String
		map.put("b", 10.5); // Double
		map.put("c", new int[] {10, 20, 30, 40, 50}); // int 배열 > toString없어서 주소값 나옴
		
		System.out.println(map);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String mapJason = gson.toJson(map);
		
		System.out.println(mapJason);
		
	}

}
