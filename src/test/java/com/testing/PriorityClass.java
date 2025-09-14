package com.testing;

import org.testng.annotations.Test;

public class PriorityClass {
	
	@Test(priority=-5)
	private void login() {
		System.out.println("LOGIN");
	}
	@Test(priority=0)
	private void search() {
		System.out.println("Search");
	}
	@Test(priority=5)
	private void addToCart() {
		System.out.println("ADDTOCART");
	}


}
