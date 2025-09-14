package com.testing;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.NakuriProject.BaseClass;

public class CrossBrowser extends BaseClass {
	//@Test(enabled=false)
	@Test()
	private void firefox() {
	    browserlaunch("firefox");
		launchingUrl("https://www.naukri.com/");
		System.out.println("Browser ID:"+Thread.currentThread().getId());		
	}
@Ignore
//@Test

private void chrome() {
    browserlaunch("chrome");
	launchingUrl("https://www.naukri.com/");
	System.out.println("Browser ID:"+Thread.currentThread().getId());		
}

@Test

private void edge() {
    browserlaunch("edge");
	launchingUrl("https://www.naukri.com/");
	System.out.println("Browser ID:"+Thread.currentThread().getId());		
}
	

}
