package com.source.code.groups;

import org.testng.annotations.Test;

@Test(groups="stu")
public class GroupsOnClass1 {
	
	public void stu1() {
		System.out.println("GroupsOnClass1's stu1 run");
	}
	
	public void stu2() {
		System.out.println("GroupsOnClass1's stu2 run");
	}
}
