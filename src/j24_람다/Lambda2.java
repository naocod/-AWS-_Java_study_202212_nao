package j24_람다;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Lambda2 {
	
	public static void main(String[] args) {
		
		// 1. Runnable - run()
		// 익명으로 정의와 생성 동시에
		Runnable a = () -> System.out.println("실행");
		// 두개 이상부터는 중괄호 써워야됨
		Runnable b = () -> {
			System.out.println("여");
			System.out.println("러");
			System.out.println("명");
			System.out.println("령");
			System.out.println("실");
			System.out.println("행");
		};
		
		a.run();
		b.run();
		
		// 2. Supplier - get()
		Supplier<LocalDate> c = () -> LocalDate.now();
		Supplier<String> d = () -> {
			LocalDate now = LocalDate.now();
			return now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
		};
		
		System.out.println(c.get());
		System.out.println(d.get());
		
		// 3. Consumer<T> - void accept(T t)
//		Consumer<String> e = name -> System.out.println("이름: " + name);
		Consumer<String> e = name -> {
			System.out.println("이름: " + name);
			System.out.println("오늘 날짜: " + d.get());
		};
		
		e.accept("이종현");
		
		// 메소드 참조 표현식 ([인스턴스]::[메소드명 또는 new])
		Consumer<String> f = System.out :: println;
		f.accept("출력");
		
		List<String> names = new ArrayList<>();
		names.add("김동민");
		names.add("김두영");
		names.add("장진원");
		names.add("조병철");
		
		// forEach안에 매개변수로 Consumer가 있어서 forEach문으로 사용 가능
		names.forEach(name -> System.out.println("이름: " + name + "님"));
		System.out.println("----------------------");
		
		Consumer<String> g = name -> System.out.println("이름: " + name + "님"); 
		names.forEach(g);
		
	    // this => names(list)
//		default void forEach(Consumer<? super String> action) { // names의 제네릭 타입을 String으로 잡았기에 forEach의 제네릭 타입도 String이 됨
//	        Objects.requireNonNull(action);
//	        for (String t : this) {
//	            action.accept(t); // accept는 Consumer에서 호출됨(Consumer 메소드)
//	        }
//	    }
		
		names.forEach(name -> {
			System.out.println("이름을 출력합니다.");
			System.out.println("이름: " + name);
			System.out.println();
		});
		
		Map<String, String> userMap = new HashMap<>();
		userMap.put("username", "aaa");
		userMap.put("password", "1234");
		
		// entrySet으로 key와 value를 꺼냄
		userMap.forEach((key, value) -> {
			System.out.println("key: " + key);
			System.out.println("value: " + value);
			System.out.println();
		});
		
		for(Entry<String, String> entry : userMap.entrySet()) {
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue());
			System.out.println();
		}
	}

}

























