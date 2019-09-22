package com.source.code.autotest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BasicAnnotation {
	@Test
  public void testcase1() {
		System.out.println("test case 1");
	}
	
	@Test
	  public void testcase2() {
			System.out.println("test case 2");
		}
	
	@BeforeMethod
 public void BeforeMethod() {
		System.out.println("before each test case");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("after each test case");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class run");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after class run");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite run");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite run");
	}
}

//class BasicAnnotation2{
//	@Test
//	public void testCase3() {
//		System.out.println("test case in another class");
//	}
//}