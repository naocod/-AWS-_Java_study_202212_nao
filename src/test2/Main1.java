package test2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Product {
	private int serialNumber;
	private String productType;
	private String productName;
	private int price;
}

public class Main1 {
	
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		Product product = new Product(2001, "laptop", "Samsung GalaxyBook", 1400000);
		
//		System.out.println(gson.toJson(product));
		
		String productJson = gson.toJson(product);
		System.out.println(productJson);
	}

}
