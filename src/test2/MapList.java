package test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapList {
	
	public static void main(String[] args) {
		List<String> colors = new ArrayList<>();
		colors.add("red");
		colors.add("green");
		colors.add("blue");
		
		List<String> sizes = new ArrayList<>();
		sizes.add("SS");
		sizes.add("S");
		sizes.add("M");
		sizes.add("L");
		sizes.add("XL");
		
		Map<String, List<String>> options = new HashMap<>();
		
		options.put("색상", colors);
		options.put("사이즈", sizes);
		
		
		for(Map.Entry<String, List<String>> entry : options.entrySet()) {
			System.out.println(entry);
		}
	}

}
