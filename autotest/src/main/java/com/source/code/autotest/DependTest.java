package com.source.code.autotest;

import org.testng.annotations.Test;

public class DependTest {
    @Test
	public void test1() {
		System.out.println("test1 run");
		// throw new RuntimeException(); if uncomment this line test2 won't execute will ignore
	}
	
    @Test(dependsOnMethods= {"test1"})
	public void test2() {
		System.out.println("test2 run");
	}
}
