package com.testing;

import org.testng.annotations.Test;

import com.NakuriProject.BaseClass;

public class InvocationCountClass extends BaseClass {
	
	@Test(invocationCount = 5)
	private void demo() {
		
		browserlaunch("chrome");
		launchingUrl("https://www.naukri.com/");
		browserTerminate();
	}

}
