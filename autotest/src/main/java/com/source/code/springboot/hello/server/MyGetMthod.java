package com.source.code.springboot.hello.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@Api(value = "/",description="this all my get methods")
public class MyGetMthod {
    @RequestMapping(value="/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "Invoke this method would get cookies",httpMethod = "GET")
	public String getCookies(HttpServletResponse response) {
    	
    	//zhuang xiangyin xinxi de lei
    	Cookie cookie = new Cookie("login2", "true2");
    	response.addCookie(cookie);
		return "get cookies successfully";
	}
    
  //Client access with Cookies, Use JMETER HTTP Cookies manager -> HTTP request ->View Result TREE
    @RequestMapping(value="/demo/with/cookies",method = RequestMethod.GET )
    @ApiOperation(value = "Client access with Cookies",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request) {
    	Cookie[] cookies = request.getCookies();
    	if (Objects.isNull(cookies)) {
			return  "you must access with Cookies";
		}
    	 for (Cookie cookie : cookies) {
			if (cookie.getName().equals("login2") && cookie.getValue().equals("true2")) {
				return "Access Successfully";
			}
		}
    	return "you must access with Cookies";
    }
    
    
    
    // An Get request need have parameter
    // 1. url: key=value&key=value e.g. http://localhost:8888/get/with/parameter?start=10&end=1
    // 2. @PathVariable  e.g. http://localhost:8888/get/with/parameter/10/1
    // if secnario2 @RequestMapping(value="/get/with/parameter/{start}/{end}")
    @RequestMapping(value="/get/with/parameter",method = RequestMethod.GET)
    @ApiOperation(value = "Get request need have parameter",httpMethod = "GET")
     public Map<String, Integer> getList(@RequestParam Integer start, @RequestParam Integer end){
    	 Map<String, Integer> myListMap = new HashMap<String, Integer>();
    	 myListMap.put("noodle", 1);
    	 myListMap.put("shoes", 200);
    	 myListMap.put("egg", 3);
    	 return myListMap; 
     }
}


