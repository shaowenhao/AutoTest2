package com.source.code.autotest.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {
    @BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite run ...");
	}
	
    @AfterSuite
	public void afterSuite() {
		System.out.println("after suite run ---");
	}
    
    @BeforeTest
    public void beforeTest() {
    	System.out.println("before test");
    }
    
    @AfterTest
    public void afterTest() {
    	System.out.println("after test" );
    }
}
