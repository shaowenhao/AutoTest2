package com.source.code.multithread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotation {

	@Test(invocationCount=10,threadPoolSize=3)
	public void test() {
		System.out.println(1);
		System.out.printf("Thread ID was %s%n",Thread.currentThread().getName());
	}
}
