package j20_JSON;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import j20_JSON.builder.User;

public class JsonMap {
	
	public static void main(String[] args) {
		
		Gson gson = new Gson();
		gson = new GsonBuilder().setPrettyPrinting().create();
		
		Map<String, Object> user = new HashMap();
		user.put("username", "aaa");
		user.put("password", "1234");
		user.put("name", null);
		
		String userJson = gson.toJson(user);
		System.out.println(user);
		System.out.println(userJson);
		
		Map<String, Object> userMap = gson.fromJson(userJson, Map.class);
		User userObj = gson.fromJson(userJson, User.class);
		
		System.out.println(userMap);
		System.out.println(userObj);
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("test1", "aaa");
		jsonObject.addProperty("test2", "bbb");
		jsonObject.addProperty("test3", "ccc");
		
//		System.out.println(jsonObject);
		
		String jsonObjectStr = jsonObject.toString();
		System.out.println(jsonObjectStr);
	}

}
