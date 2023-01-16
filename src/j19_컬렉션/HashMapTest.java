package j19_컬렉션;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapTest {
	
	public static void main(String[] args) {
		
		Map<String, Object> dataMap = new HashMap<>(); 
		dataMap.put("username", "aaa");
		dataMap.put("password", "1234");
		dataMap.put("name", "nao");
		dataMap.put("email", "email@gmail.com");
		
		// Object로 받기 때문에 value측에 리스트를 넣을 수 있음 
		// > 따로 빼서 쓰고싶을 땐 Object로 업캐스팅되어있기에 맞는 자료형으로 다운캐스팅해서 써야함
		List<String> hobby = new ArrayList<>();
		hobby.add("골프");
		hobby.add("축구");
		hobby.add("농구");
		hobby.add("음악감상");
		
		dataMap.put("hobbys", hobby);
		
		System.out.println(dataMap);
		// 해쉬코드로 인한 정렬이기에 뒤죽박죽나옴(순서x)
		
		List<String> list = (List<String>)dataMap.get("hobbys"); // Object 타입이기에 List로 다운캐스팅
		System.out.println(list.get(0));
	}

}
