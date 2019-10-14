package com.source.code.httpclient.cookie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyCookiesForPost {

	private String url;
	private String cookieUrl;
	private String postWithCookieUrl;
	//cookie信息的变量
	private CookieStore store;
	
	@BeforeTest
	public void beforeTest() {
	 Properties properties = new Properties();
	 try {
		String path = System.getProperty("user.dir");
		BufferedReader reader = new BufferedReader(new FileReader(path + "/src/main/resources/httpclient.properties"));
		properties.load(reader);
		url = properties.getProperty("test.url");
		cookieUrl = properties.getProperty("getCookies.url");
		postWithCookieUrl= properties.getProperty("post.with.cookies");
	 } catch (FileNotFoundException e) {
		e.printStackTrace();
	 } catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	@Test
	public void testGetCookies() throws ClientProtocolException, IOException {
		
		HttpGet httpGet = new HttpGet(url + cookieUrl);
		 store = new BasicCookieStore();
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(store).build();
		HttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		String result=EntityUtils.toString(entity,"utf-8");
		System.out.println(result);	
		//get cookies先  
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie : cookieList) {
			String name = cookie.getName();
			String value = cookie.getValue();
			System.out.println("Cookie name:"+name +"; Cookie value:"+value);
		}
	}
	
	@Test(dependsOnMethods= {"testGetCookies"}) 
	public void testPostMethod() throws ClientProtocolException, IOException {
		String testUrl = url + postWithCookieUrl;
		// Define client对象，用来进行方法的执行
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(store).build();  
		// Define post 方法
		HttpPost post = new HttpPost(testUrl);
		// add parameters
		JSONObject param = new JSONObject();
		param.put("name", "ryan");
		param.put("age", "31");
		//set request header info
		post.setHeader("content-type", "application/json");
		
		StringEntity entity = new StringEntity(param.toString(), "utf-8");
		post.setEntity(entity); 
		
		String result;
		CloseableHttpResponse response = httpClient.execute(post); 
		result=EntityUtils.toString(response.getEntity(),"utf-8");
		System.out.println("result " + result);
		
		JSONObject resultJson = new JSONObject(result);
		String success = (String) resultJson.get("ryan");
		System.out.println("Congratuations " + success); 
		
	}
}
//get cookies successfully
//Cookie name:login; Cookie value:true
//result {"ryan":"good job"}
//Congratuations good job


//java -jar moco-runner-1.0.0-standalone.jar http -p 12306 -c startup_cookie.json

//[
// {
//  "description":"this will return cookie get",
//  "request":{
//    "uri":"/getCookies",
//	"method":"get"
//  },
//  "response":{
//   "cookies":{
//	   "login":"true"
//	 },
//    "text":"get cookies successfully"
//  }
// },
// {
//   "description":"this is have cookie get",
//      "request":{
//     "uri":"/demo/with/cookies",
//	 "method":"get",
//	 "cookies":{
//	   "login":"true"
//	 }
//   },
//   "response":{
//     "text":"welcome moco get with cookies"
//   }
// }, {
//   "description":"this is have cookie post",
//      "request":{
//     "uri":"/post/with/cookies",
//	 "method":"post",
//	 "cookies":{
//	   "login":"true"
//	 },
//	 "json":{
//	   "name":"ryan",
//	   "age":"31"
//	 }
//   },
//   "response":{
//     "status":200,
//	 "json":{
//	   "ryan":"good job"
//	 }
//   }
// }
//
//]