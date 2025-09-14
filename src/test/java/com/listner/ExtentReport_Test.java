package com.listner;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.NakuriProject.BaseClass;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReport_Test {
	
	public static ExtentTest extentTest;
	
	@BeforeSuite
	
	private void extentTestReportStartup()throws IOException {
		
		BaseClass base = new BaseClass() {
			
		};
		base.extentReportStart(null);
	}
	
	@AfterSuite
	
	private void extentReportEn()throws IOException {
       
		BaseClass base = new BaseClass() {
			
		};
		base.extentReportTearDown(null);
	}


}
