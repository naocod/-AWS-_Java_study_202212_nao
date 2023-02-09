package usermanagement.server.controller;

import java.util.Map;

import usermanagement.dto.ResponseDto;
import usermanagement.entity.User;
import usermanagement.service.UserService;

public class AccountController {

	private static AccountController instance;
	private UserService userService;
	
	private AccountController() {
		userService = UserService.getInsance();
	}
	
	public static AccountController getInstance() {
		if(instance == null) {
			instance = new AccountController();
		}
		return instance;
	}
	
	
	public ResponseDto<?> register(String userJson) {
		
		Map<String, String> resultMap = userService.register(userJson);
		
		if(resultMap.containsKey("error")) {
			return new ResponseDto<String>("error", resultMap.get("error"));
		}
		
//		return new ResponseDto<String>("ok", "회원가입 성공");
		return new ResponseDto<String>("ok", resultMap.get("ok"));
	}
	
}







