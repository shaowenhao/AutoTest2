package com.source.code.parameter;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@Test(dataProvider="data")
	
	public void testDataProvider(String name, int age) {
		System.out.println("name:"+name+"age:"+age);
	}
	
	@DataProvider (name="data")
	public Object[][] providerData(){
		Object[][] objects = new Object[][] {
			{"zhangsan",10},
			{"lisi",20},
			{"wangwu",30}
		};
		return objects; 
	}
	
	@Test(dataProvider="methodData")
	public void test1(String name, int age) {
		System.out.println("test1 name="+name + "age="+ age);
	}
	
	@Test(dataProvider="methodData")
	public void test2(String name, int age) {
		System.out.println("test2 name="+name + "age="+ age);
	}
	
	  @DataProvider(name="methodData")
	  public Object[][] methodaTest(Method method){
		  Object[][] result = null;
		  if (method.getName().equals("test1")) {
			  result = new Object[][] {
				  {"ryan",30},
				  {"Iris",29}
			  };
		  }else if (method.getName().equals("test2")) {
			  result = new Object[][] {
				  {"philip",40},
				  {"Jesica",40}
			  };
		}
		  return result;
	  }
	 }
