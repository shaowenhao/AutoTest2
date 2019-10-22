package com.source.code.springboot.hello.server;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "/",description = "this all my post methods" )
//@RequestMapping("/v1")
public class MyPostMethod {
 
	private static Cookie cookie;
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ApiOperation(value="login in successfully, get cookie",httpMethod = "POST")
	public String login(HttpServletResponse response,
			@RequestParam String userName,
			@RequestParam String password) {
		if(userName.equals("ryan")&&password.equals("123456")) {
			cookie= new Cookie("login", "true");
			response.addCookie(cookie);
			return "Login Successfully";
		}else {
			return "Login failed";
		}
		
	}
	
	@RequestMapping(value="/getUserList",method = RequestMethod.POST)
	public String getUserList(HttpServletRequest request,
			@RequestBody User u) {
		  Cookie[] cookies = request.getCookies();
		  User user;
		  for (Cookie cookie : cookies) {
			if(cookie.getName().equals("login")&&cookie.getValue().equals("true")) {
				user= new User();
				user.setName("Iris");
				user.setAge("30");
				user.setSex("female");
				return user.toString();
			}
		}
		  return "Filed";
	}
}
