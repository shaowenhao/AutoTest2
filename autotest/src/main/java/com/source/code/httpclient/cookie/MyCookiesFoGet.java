package com.source.code.httpclient.cookie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyCookiesFoGet {

	private String url;
	private String cookieUrl;
	private String getWithCookieUrl;
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
		getWithCookieUrl= properties.getProperty("demo.with.cookies");
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
		//HttpClient httpClient= HttpClients.createDefault();		
		//DefaultHttpClient httpClient = new DefaultHttpClient(); deprecated
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
	// 然后携带cookie信息访问get请求
	public void testGetWithCookies() throws ClientProtocolException, IOException {
		HttpGet httpGet = new HttpGet(url + getWithCookieUrl);
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(store).build();
		// Cookie信息设置
		HttpResponse response =  httpClient.execute(httpGet);
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode==200) {
			HttpEntity entity = response.getEntity();
			String result=EntityUtils.toString(entity,"utf-8");
			System.out.println(result);
		}else {
			System.out.println("xxxxxxxxxxxxxx");
		}
		
	}
}
