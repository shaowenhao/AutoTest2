package com.source.code.httpclient.cookie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyCookiesFoGet {

	private String url;
	private String cookieUrl;
	@BeforeTest
	public void beforeTest() {
	 Properties properties = new Properties();
	 try {
		String path = System.getProperty("user.dir");
		BufferedReader reader = new BufferedReader(new FileReader(path + "/src/main/resources/httpclient.properties"));
		properties.load(reader);
		url = properties.getProperty("test.url");
		cookieUrl = properties.getProperty("getCookies.url");
	 } catch (FileNotFoundException e) {
		e.printStackTrace();
	 } catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	@Test
	public void testGetCookies() throws ClientProtocolException, IOException {
		
		HttpGet httpGet = new HttpGet(url + cookieUrl);
		HttpClient httpClient= HttpClients.createDefault();
		HttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		String result=EntityUtils.toString(entity,"utf-8");
		System.out.println(result);
	}
	
}
