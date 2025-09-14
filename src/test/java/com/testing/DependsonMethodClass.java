package com.testing;

import org.testng.annotations.Test;

public class DependsonMethodClass {
	
	@Test(expectedExceptions = ArithmeticException.class)
//	@Test
	private void sampleOne() {
		
		int a= 10;
		System.out.println(a/0);
		System.out.println("Sample One");
	}
	@Test
	
	private void sampleTwo() {
		
				System.out.println("Sample Two");
	}
	@Test(dependsOnMethods = {"sampleOne","sampleTwo"})
	
	private void sampleThree() {
		
				System.out.println("Sample Three");
	}


}
