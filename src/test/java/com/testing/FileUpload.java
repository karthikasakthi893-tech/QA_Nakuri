package com.testing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.beust.jcommander.Strings;

public class FileUpload {
	@Test
	private void fileUploads() throws AWTException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.ilovepdf.com/pdf_to_word");
		driver.findElement(By.xpath("//span[text()='Select PDF file']")).click();
		
		Robot robot = new Robot();
		robot.delay(2000);
		StringSelection ss = new StringSelection("C:\\Users\\karth\\Documents\\Selenium with java course 2025\\Moc Test\\SeleniumQueandans.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);

	}

}
