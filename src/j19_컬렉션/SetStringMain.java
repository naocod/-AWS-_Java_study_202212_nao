package j19_컬렉션;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetStringMain {
	
	public static void main(String[] args) {
		Set<String> setStr = new HashSet<>();
		// HashSet 해쉬 값을 가지고 정렬하는 방식 > 순서 없음
		// 같은 값을 넣으면 add를 여러번 해도 하나만 들어갈 수 있음
		List<String> listStr = new ArrayList<>();
		
		listStr.add("나오");
		listStr.add("나오1");
		listStr.add("나오");
		listStr.add("나오");
		
		System.out.println(listStr);
		
		setStr.add("nao1");
		setStr.add("nao2");
		setStr.add("nao3");
		setStr.add("nao4");
		setStr.addAll(listStr); // 타입이 Collection이기 때문에 업캐스팅을 통해 Collection 객체를 매개변수로 다 받을 수 있음
		// All로 넣으면 중복 제거 해줌
		// Map은 Collection에 상속받지 않기 때문에 addAll이 안됨
		// set을 통해 빼낼 수 있고 value들을 list형태로 빼낼 수 있음
		// map 은 키값이고     //
		
		System.out.println(setStr); // set은 get없음 > key값이 없기 때문
		String searchName = "nao1";
		
		for(String name : setStr) { // set은 무조건 foreach돌려서 다 꺼낸다음 찾는 값을 비교해야 함
			if(name.equals(searchName)) {
				System.out.println(name);
			}
		}
		
		Iterator<String> iterator = setStr.iterator();
		while(iterator.hasNext()) { // iterator에 넣어놓고 next로 꺼내옴 > 인덱스 필요없음
			String n = iterator.next();
			if(n.equals(searchName)) {
				System.out.println(n);
			}
		}
		
	}

}
