package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NakuriProject.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.interfaceelements.NakuriLoginPageInterfaceElements;
import com.pageobjectmanager.PageObjectManager;
import com.utility.ExcelUtility;

public class NakuriLoginPage extends BaseClass implements NakuriLoginPageInterfaceElements  {
	@FindBy(xpath = username_xpath)
	private WebElement username;
	
	@FindBy(xpath = password_xpath)
	private WebElement password;

	@FindBy(xpath = login_xpath)
	private WebElement login;

	@FindBy(xpath = Loginbutton_xpath)
	private WebElement loginbutton;
	
//	@FindBy(xpath = chatbox_xpath)
//	private WebElement chatbox;
	
	@FindBy(xpath=title_xpath)
	private WebElement title;

	public NakuriLoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
   public boolean validLogin(ExtentTest extentTest) throws IOException, InterruptedException {
	   	try {
			elementClick(loginbutton); 	
			Thread.sleep(3000);
			inputPassing(username, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("username1"));
			inputPassing(password, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("pass"));
			elementClick(login);
			Thread.sleep(3000);
		    validation(title,ExcelUtility.getCellValue("DATA", "ID", "Title"));
			extentTest.log(Status.PASS, "Login Successfully");
//			elementClick(chatbox);

		} catch (AssertionError e) {
			extentTest.log(Status.FAIL, "Login Failed" + e.getMessage());
			return false;
			
		}
		return true;
		

}

}
