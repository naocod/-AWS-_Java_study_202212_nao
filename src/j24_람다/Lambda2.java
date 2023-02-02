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
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda2 {
	
	public static void main(String[] args) {
		
		// 1. Runnable - run()
		// 익명으로 정의와 생성 동시에
		System.out.println("1. Runnable - run()");
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
		System.out.println("\n2. Supplier - get()");
		Supplier<LocalDate> c = () -> LocalDate.now();
		Supplier<String> d = () -> {
			LocalDate now = LocalDate.now();
			return now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
		};
		
		System.out.println(c.get());
		System.out.println(d.get());
		
		// 3. Consumer<T> - void accept(T t)
		System.out.println("\n3. Consumer<T> - void accept(T t)");
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
		
		
		// 4. Function<T, R> - 일회성으로 만들 때 사용함
		
		Function<String, Integer> h = num -> Integer.parseInt(num);
		
		int convertStrNum1 = h.apply("10000"); // apply 가 num -> Integer.parseInt(num)를 실행함 -> 따라서 string 타입의 10000을 int타입으로 변환하여 변수에 저장
		int convertStrNum2 = h.apply("20000");
		
		System.out.print("4. Function<T, R>: ");
		System.out.println(convertStrNum1 + convertStrNum2);
		
		
		// 5. Predicate<T>
		Predicate<String> p = str -> str.startsWith("김");
		Predicate<String> p2 = str -> str.startsWith("이");
		
				
		System.out.print("5-1. Predicate 조건 1개: ");
		System.out.println(p.test("김준일"));
		// 조건을 2개 주고 싶은 경우
		System.out.print("5-2. Predicate 조건 2개: ");
		System.out.println(p.or(p2).test("준일"));
		
		// p, p2 없이 바로 람다로 직접 넣어서 생성하고 정의함
		Function<Predicate<String>, Boolean> funtion1 = 
				predicate -> predicate.or(str -> str.startsWith("이")).test("김준일");
				
		boolean rs = funtion1.apply(str -> str.startsWith("김"));
		System.out.print("5-3. 람다로 직접 생성: ");
		System.out.println(rs);
		
		
		List<String> nameList= new ArrayList<>();
		nameList.add("김종환");
		nameList.add("고병수");
		nameList.add("김상현");
		nameList.add("김준경");
		
		// 스트림 -> 일회성
		Stream<String> stream = nameList.stream();
		System.out.print("5-4. 스트림 객체 생성: ");
		System.out.println(stream);
		
		System.out.println("5-5. 스트림 객체 출력 ");
		stream.forEach(name -> System.out.println(name));
		
		System.out.println("5-6. 스트림 필터 적용 ");
		Stream<String> stream2 = nameList.stream().filter(name -> name.startsWith("김"));
//		stream2.forEach(name -> System.out.println(name));
		
		// 일회성 특성 때문에 이미 위에서 forEach를 돌리면서 하나씩 꺼내져서 stream에 남은게 없음
		System.out.print("5-7. 스트림 리스트 형식: "); 
		List<String> newList = stream2.collect(Collectors.toList());
		System.out.println(newList);
		
		System.out.println("5-8. 스트림 리스트 forEach "); 
		newList.forEach(str -> System.out.println(str));
		
		System.out.println("===========================================");
		
		nameList.stream()
			.filter(name -> name.startsWith("김"))
			.collect(Collectors.toList())
			.forEach(System.out::println); // .forEach(name -> System.out.println(name));
	}

}

























