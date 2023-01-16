package j19_컬렉션;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapStringMain {
	
	public static void main(String[] args) {
		
		Map<String, String> strMap = new HashMap<>();
		
		strMap.put("다", "a");
		strMap.put("라", "b");
		strMap.put("가", "c");
		strMap.put("나", "d");
		
		System.out.println(strMap);
		
		System.out.println(strMap.get("a"));
		System.out.println(strMap.get("e")); // 없는 key값은 null로 출력됨
		
		// map은 키와 value가 한쌍이기에 foreach 못돌림
		
		for(String k: strMap.keySet()) { // key값들만 set으로 돌림
			System.out.println("key: " + k);
			System.out.println(strMap.get(k)); // get을 통해 key에 맞는 value값 들고옴
//			System.out.println(s);
		}
		
		for(String v : strMap.values()) { // Collection으로 빠짐
			System.out.println("value: " + v); 
		}
		
		// 해쉬코드(문자열을 코드로 변환한 값) 값이 정렬되어 나오기에 순서되어 나옴 
		// 키값이 한글이면 순서대로 안나옴..?
		
//		System.out.println(strMap.entrySet()); // 결국엔 set이기에 key와 value를 묶어서 하나의 set으로 봄
		// 전체는 Map이고 각각의 값은 엔트리임
		
		Set<Entry<String, String>> s = null; // 엔트리를 담는 Set
		
		for(Entry<String, String> entry : strMap.entrySet()) {
			System.out.println(entry);
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue()); // 키와 value를 따로 뽑을 수 있음
			System.out.println();
		}
		
		System.out.println("=========================================");
		
		strMap.forEach((k, v) -> {
			System.out.println("key: " + k);
			System.out.println("value: " + v);
		});
		
	}

}
