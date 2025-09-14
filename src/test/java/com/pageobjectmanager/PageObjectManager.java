package com.pageobjectmanager;

import com.pageobjectmodel.NakuriLoginPage;
import com.pageobjectmodel.ProfileUpdatePage;
import com.pageobjectmodel.ResumeUploadPage;
import com.projectobjectmodel.LoginPage;
import com.projectobjectmodel.SearchPage;
import com.utility.FileReaderManager;

public class PageObjectManager {
 
	private LoginPage loginPage;
	private FileReaderManager fileReader;
	private static PageObjectManager pageObjectManager;
	private SearchPage searchPage;
	private NakuriLoginPage nakuriLoginPage;
	private ProfileUpdatePage profileUpdate;
	private ResumeUploadPage resumeUploadPage;
	
	
	public NakuriLoginPage getNakuriLoginPage() {
		if(nakuriLoginPage == null) {
			nakuriLoginPage = new NakuriLoginPage();	
		}
		return nakuriLoginPage;
		
	}
	public LoginPage getLoginPage() {
		if(loginPage == null) {
		loginPage = new LoginPage();	
		}
		return loginPage;
		
	}
	public FileReaderManager getFileReader() {
		if(fileReader == null) {
			fileReader = new FileReaderManager();	
		}
		return fileReader;
		
	}
	public static PageObjectManager getPageObjectManager() {
		if(pageObjectManager == null) {
			pageObjectManager = new PageObjectManager();	
		}
		return pageObjectManager;
		
	}
	public SearchPage getSearchPage() {
		if(searchPage == null) {
			searchPage = new SearchPage();	
		}
		return searchPage;
		
	}
	public ProfileUpdatePage getProfileUpdate() {
		if (profileUpdate==null) {
			
			profileUpdate = new ProfileUpdatePage();
			
		}
		
		return profileUpdate;

	}
	public ResumeUploadPage getResumeUpload() {
		if (resumeUploadPage==null) {
			
			resumeUploadPage = new ResumeUploadPage();
			
		}
		
		return resumeUploadPage;

	}

	
}
