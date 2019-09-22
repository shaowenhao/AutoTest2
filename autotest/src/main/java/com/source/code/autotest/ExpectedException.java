package com.source.code.autotest;

import org.testng.annotations.Test;

public class ExpectedException {

	@Test(expectedExceptions = RuntimeException.class)
	public void ExpectedException() {
		//System.out.println("expected expection happen");
		throw new RuntimeException();
	}
}
