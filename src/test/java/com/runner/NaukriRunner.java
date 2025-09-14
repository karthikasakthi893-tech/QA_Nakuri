package com.runner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.NakuriProject.BaseClass;
import com.listner.ExtentReport_Test;
import com.listner.ITestListenerClass;
import com.pageobjectmanager.PageObjectManager;
@Listeners(ITestListenerClass.class)
public class NaukriRunner extends BaseClass {

	@BeforeClass
	private void propertySetup() {
		
		browserlaunch(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("browser"));
		launchingUrl(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("url"));	
	}
	@Test
	private void NakuriLogin() throws InterruptedException, IOException {
	ExtentReport_Test.extentTest=extentReports.createTest("LOGIN TEST" + ":" + Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("Nakuri Application Testing");
	Assert.assertTrue(PageObjectManager.getPageObjectManager().getNakuriLoginPage().validLogin(ExtentReport_Test.extentTest));
//  PageObjectManager.getPageObjectManager().getNakuriLoginPage().validLogin();
	}
	
	@Test
	private void ProfileUpdate() throws InterruptedException {
		PageObjectManager.getPageObjectManager().getProfileUpdate().profileUpdation();
  
	}
	
	@Test
	private void resumepload() throws InterruptedException {
		PageObjectManager.getPageObjectManager().getResumeUpload().resumefileupload();
 
	}
//	
	
//	@AfterClass
//	private void termination() {
//
//		browserTerminate();
//	}
	@BeforeSuite
	private void testStart() {

		extentReportStart(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("reportstart"));
		
	}
	@AfterSuite
	private void testEnd() throws IOException {
		extentReportTearDown(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("reportend"));
		
	}
}
