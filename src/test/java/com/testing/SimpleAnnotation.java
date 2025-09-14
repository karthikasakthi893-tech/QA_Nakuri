package com.testing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleAnnotation {
	@BeforeSuite
	private void propertySettings() {
		
		System.out.println("Property Settings");		
	}
	
@BeforeTest		
private void BrowseUrl() {
		
		System.out.println("Browse the URL");		

	}

@BeforeClass
private void LaunchUrl() {
	
	System.out.println("Launching the URL");		

}
@BeforeMethod
private void login() {
	
	System.out.println("Login");		

}
@Test
private void mobile() {
	
	System.out.println("mobile");		

}
@Test
private void laptop() {
	
	System.out.println("laptop");		

}
@Test
private void Gadgets() {
	
	System.out.println("Gadgets");		

}

@AfterMethod
private void logout() {
	
	System.out.println("logout");		
	System.out.println("ScreenShot");		

}
@AfterClass
private void screenShot() {
	
	System.out.println("ScreenShot");		

}
@AfterTest
private void close() {
	
	System.out.println("close");		

}
@AfterSuite
private void quit() {
	
	System.out.println("Terminate");		

}

}
