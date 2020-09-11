package com.syntax.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task2 {
	
	/*Create class that will have:
	Before and After Class annotation
	Before and After Method annotation
	2 methods with Test annotation
	 */
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("----- This is before class -----");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("----- This is after class -----");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("--- This is before method ---");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("--- This is after method ---");
	}

	@Test
	public void testOne() {
		System.out.println("- This is test one -");
	}

	@Test
	public void testTwo() {
		System.out.println("- This is test two -");
	}


}
