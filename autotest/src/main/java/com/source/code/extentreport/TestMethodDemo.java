package com.source.code.extentreport;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodDemo {

	@Test
	public void test1() {
		Assert.assertEquals(1, 1);
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(1, 2);
		
	}
	
	@Test
	public void logDemo() {
		Reporter.log("wirte by ryan");
		throw new RuntimeException("exception 111");
	}
	
}
