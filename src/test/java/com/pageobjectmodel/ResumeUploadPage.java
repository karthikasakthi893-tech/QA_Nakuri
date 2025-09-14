package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v115.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NakuriProject.BaseClass;
import com.interfaceelements.ResumeUploadInterfaceElements;
import com.pageobjectmanager.PageObjectManager;

public class ResumeUploadPage extends BaseClass implements ResumeUploadInterfaceElements{
	
	@FindBy(xpath = resumeUpload_xpath)
	private WebElement resume;
	
	public ResumeUploadPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void resumefileupload() throws InterruptedException {
		
		Thread.sleep(2000);
//		(, "");
		fileUload(resume, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("resumeupload"));

	}

}
