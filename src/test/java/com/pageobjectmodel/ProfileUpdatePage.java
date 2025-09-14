package com.pageobjectmodel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.NakuriProject.BaseClass;
import com.interfaceelements.ProfileUpdateInterfaceElemets;
import com.pageobjectmanager.PageObjectManager;

public class ProfileUpdatePage extends BaseClass implements ProfileUpdateInterfaceElemets {
	
	
//	@FindBy(xpath = chatBox_xpath)
//	private WebElement chatBox;
	
	@FindBy(xpath = profileupdate_xpath)
	private WebElement profile;
	
	@FindBy(xpath = view_xpath)
	private WebElement view;
	
	@FindBy(xpath = edit_xpath)
	private WebElement edit;
	
	@FindBy(xpath = worksatus_xpath)
	private WebElement work;
	
	@FindBy(xpath = experienceyear_xpath)
	private WebElement experience;
	
	@FindBy(xpath = yearselect_xpath)
	private WebElement yearselect;
	
	@FindBy(xpath = month_xpath)
	private WebElement month;
	
	@FindBy(xpath = monthselect_xpath)
	private WebElement monthselect;
	
	@FindBy(xpath = currency_xpath)
	private WebElement currency;
	
	@FindBy(id = amount_id)
	private WebElement amount;
	
	@FindBy(id = salarycomponent_id)
	private WebElement salarycomponent;
	
	@FindBy(xpath = salaryselect_xpath)
	private WebElement salaryselect;
	
	@FindBy(xpath = currentlocation_xpath)
	private WebElement currentlocation;
	
	@FindBy(xpath = loctiontext_xpath)
	private WebElement loctiontext;
	
	@FindBy(xpath = locationselect_xpath)
	private WebElement locationselect;
	
//	@FindBy(id = county_id)
//	private WebElement county;
//	
//	@FindBy(xpath = countrycode_xpath)
//	private WebElement countrycode;
//	
//	@FindBy(xpath = areaycode_xpath)
//	private WebElement areaycode;
//	
//	@FindBy(xpath = phonenum_xpath)
//	private WebElement phonenum;
//	
	@FindBy(xpath = joiningmonth_xpath)
	private WebElement joiningmonth;
	
	@FindBy(xpath = save_xpath)
	private WebElement save;
	
	
	public ProfileUpdatePage() {
		PageFactory.initElements(driver, this);

	}

	
	public void profileUpdation() throws InterruptedException {
		
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	wait.until(ExpectedConditions.elementToBeClickable(profile));
	    implicitlyWait("seconds", 10);
        elementClick(profile);
		Thread.sleep(2000);
		elementClick(view);
		Thread.sleep(2000);
		elementClick(edit);
		Thread.sleep(2000);
		elementClick(work);
		backspace(experience);
		elementClick(experience);
		Thread.sleep(2000);
	    elementClick(yearselect);
		Thread.sleep(2000);
		backspace(month);
		elementClick(month);
		implicitlyWait("seconds", 10);
		elementClick(monthselect);
		elementClick(currency);
		implicitlyWait("seconds", 10);
		backspace(amount);
		inputPassing(amount, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("salaryamount"));
		elementClick(salarycomponent);
    	implicitlyWait("seconds", 10);
		elementClick(salaryselect);
		elementClick(currentlocation);
    	implicitlyWait("seconds", 10);
		backspace(loctiontext);
		elementClick(loctiontext);
    	Thread.sleep(3000);
		elementClick(locationselect);
		elementClick(joiningmonth);
//		scrollToElement(save, "viewelement");
//	    scrollToElement(save, "click");
    	implicitlyWait("seconds", 10);
        elementClick(save);
	}

}
