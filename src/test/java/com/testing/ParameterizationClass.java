package com.testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.NakuriProject.BaseClass;

public class ParameterizationClass extends BaseClass {

	@Parameters({"username","password"})
	@Test()

	private void loginMethod(String username,String password) {

		browserlaunch("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		launchingUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login ");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
	}
}
