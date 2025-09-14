package com.testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.NakuriProject.BaseClass;
import com.utility.ExcelReader;

public class TestNGExcelDataProvider extends BaseClass {
	
	@DataProvider(name="excelDataProvider")
	
	public Object[][] dataProvidermethod() {
		String filePath = System.getProperty("user.dir")+"\\Excel\\TestData1.xlsx";
		String sheetName = "data";
		
		return ExcelReader.getExcelData(filePath,sheetName);

	}
	@Test(dataProvider ="excelDataProvider")
	private void loginMethod(String username,String password) {

		browserlaunch("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		launchingUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login ");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		System.out.println("UserName:"+username+"|Password:"+password);
	}

}
