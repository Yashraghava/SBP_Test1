package com.yash_project.springboot.springbootwebapp.login;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
	
	public boolean authenticate(String username,String password) {
		boolean isValidUserName = username.equals("in28minutes");
		boolean isValidPassword = password.equals("dummy");
		return isValidUserName && isValidPassword;
	}
}
