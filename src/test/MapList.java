package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapList {
	public static void main(String[] args) {
		List<Map<String, Object>> customers = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> customerInfo1 = new HashMap<>();
		
		customerInfo1.put("name", "홍길동");
		customerInfo1.put("rating", "vip");
		customerInfo1.put("age", 30);
		
		customers.add(customerInfo1);
		
		Map<String, Object> customerInfo2 = new HashMap<>();
		customerInfo2.put("name", "김기영");
		customerInfo2.put("rating", "gold");
		customerInfo2.put("age", 35);
		
		customers.add(customerInfo2);
		
		for (Map<String, Object> customer : customers) {
			System.out.println("name=" + customer.get("name"));
			System.out.println("rating=" + customer.get("rating"));
			System.out.println("age=" + customer.get("age"));
		}
	}

}
