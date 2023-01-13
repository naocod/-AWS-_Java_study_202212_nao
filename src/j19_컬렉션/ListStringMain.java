package j19_컬렉션;

import java.util.ArrayList;
import java.util.List;

public class ListStringMain {
	
	public static void main(String[] args) {
		String[] strArray = new String[] {"java", "python", "C++"};
		
		String[] newStrArray = new String[strArray.length + 1];
		
		for(int i = 0; i < strArray.length; i++) {
			newStrArray[i] = strArray[i];
		}
		newStrArray[strArray.length] = "html";
		
		System.out.println("[strArray]");
		for(String str : strArray) {
			System.out.println(str);
		}
		System.out.println();
		
		System.out.println("[newStrArray]");
		for(String str : newStrArray) {
			System.out.println(str);
		}
		System.out.println();
		
		/////////////////////////////////////////////////////////////////////////
		
		// 변수 생성 없이 new ArrayList<>();만 할 경우 비워두면 안됨
		// 변수로 넣어둬야 add 할 수 있는데 ArratList 생성할때 add를 하면 주소 자체이기에 한번 만 add 가능
		//										비워져있어도 앞쪽에서 데이터 타입을 정의하고 있기에 자동으로 String이 됨
		ArrayList<String> strList = new ArrayList<>();
		strList.add("java");
		// ((ArrayList<String>)strLis).add("java") 		제네릭 타입 사용 시 다운캐스팅이 된 녀석한테 점을 찍어서 add
		strList.add("python");
		strList.add("python");
		strList.add("python");
		strList.add("python");
		strList.add("python");
		strList.remove("java");
		// 길이가 유동적이게 됨. remove가 없으면 size가 6이고 remove 시키면 size 5 됨 -> 인덱스 정리
		strList.add(1, "java");
		strList.remove(1);
		
		// strList가 객체이기 때문에 length가 아닌 size
		for(int i = 0; i < strList.size(); i++) {
			System.out.print("[" + i + "]: ");
			System.out.println(strList.get(i));
		}
		
		for(String str : strList) {
			System.out.println(str);
		}
		
	}

}
