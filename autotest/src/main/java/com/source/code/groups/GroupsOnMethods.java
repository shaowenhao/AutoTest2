package com.source.code.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethods {
    @Test(groups = "server")
	 public void test1() {
		 System.out.println("server test case1");
	 }
    
    @Test(groups = "server")
 	 public void test2() {
 		 System.out.println("server test case2");
 	 }
    
    @Test(groups = "client")
 	 public void test3() {
 		 System.out.println("client test case3");
 	 }
    
    @Test(groups = "client")
	 public void test4() {
		 System.out.println("client test case4");
	 }
    
    @BeforeGroups("server")
    public void beforeGroupsOnServer() {
    	System.out.println("this is before server test run");
    }
    
    @AfterGroups("server")
    public void afterGroupsOnServer() {
    	System.out.println("this is after server test run!!");
    }
}

