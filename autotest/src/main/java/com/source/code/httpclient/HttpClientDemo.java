package com.source.code.httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HttpClientDemo {

	@Test
	public void testHttpClientGet() throws ClientProtocolException, IOException {
		HttpClient httpClient= HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://www.baidu.com");
		HttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		String result=EntityUtils.toString(entity,"utf-8");
		System.out.println(result);
	}
	
	
}
