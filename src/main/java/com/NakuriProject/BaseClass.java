package com.NakuriProject;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
public static WebDriver driver;
public static ExtentReports extentReports;
public static File file;


//Browser launch()
protected static void browserlaunch(String browserName) {
	try {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
	} 
	catch (Exception e) {
		Assert.fail("Error:Occur During the browser launching Check Browser name");
			}
	
}

//Get()
protected static void launchingUrl(String url) {
	try {
		driver.get(url);
		
	} catch (Exception e) {
		Assert.fail("Error:Occur During the Url launching");
	}
}

//getcurrentUrl,getTiltle
protected static void currentUrl(String value,String text) {
	try { 
		 value=driver.getCurrentUrl();
		 text=driver.getTitle();
		System.out.println("current Url: " +value);
		System.out.println("gettitle: " +text);
	} catch (Exception e) {
		Assert.fail("Error:Occur During the Url launching");
	}
}

//Sendkeys
protected static void inputPassing(WebElement element,String value) {
	try {
		element.sendKeys(value);
	} catch (Exception e) {
		Assert.fail("Error:Occur During the value passing");
			}
	
}

//Click
protected static void elementClick(WebElement element) {
	try {
		element.click();
	} catch (Exception e) {
		Assert.fail("Error:Occur During the clicking the element");
			}
}

protected static void clickElements(List<WebElement> elements) {
    try {
        for (WebElement list : elements) {
            list.click();
        }
    } catch (Exception e) {
        Assert.fail("Error: Occurred while clicking the elements - " + e.getMessage());
    }
}

protected static void submit(WebElement element) {
			element.submit();
	}

protected static void clear(WebElement element) {
	element.clear();
}


//thread
protected static void staticWait(int milisec) throws InterruptedException {
	try {
		Thread.sleep(milisec);
	} catch (Exception e) {
		Assert.fail("Error:Occur exception");
			}	
}

//Wait
protected static void implicitlyWait(String type,int duration){
	try {
		if (type.equalsIgnoreCase("seconds")) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
		}else if (type.equalsIgnoreCase("minitues")) {
			driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(duration));
		}
			} catch (Exception e) {
		Assert.fail("Error:Occur During Implict wait");
			}	
}

//Navigate back,refresh,forward
protected static void navigateMethods(String type) {
	try {
		if (type.equalsIgnoreCase("back")) {
			driver.navigate().back();
		}
		else if (type.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		}
		else if (type.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		}
	} catch (Exception e) {
		Assert.fail("Error:Occur Navigations");
			}
}

//navigateToURL
protected static void navigateToURL(String navigateURL) {
	try {
		driver.navigate().to(navigateURL);
	} catch (Exception e) {
		Assert.fail("Error:Occur Navigateurl");
	}
}

//dropDown
protected static void selectdropDown(WebElement element,String type,String value) {
	Select select = new Select(element);
	try {
		if(type.equalsIgnoreCase("index")) {
			select.selectByIndex(Integer.parseInt(value));
		}
		else if (type.equalsIgnoreCase("text")) {
			select.selectByVisibleText(value);
		}
		else if (type.equalsIgnoreCase("value")) {
			select.selectByValue(value);
		}
	} catch (Exception e) {
		Assert.fail("Error:Occur during the dropdown selection");
	}
}


//Quit
protected static void browserTerminate() {
	driver.quit();
}

//protected static void chatclose(WebElement element) {
//	driver.close(element);
//}

//Screenshot
protected static void takescreenShotFile(String location,String filename,String fileformat) {
	try {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(location+"\\"+filename+"."+fileformat);
		FileHandler.copy(source, destination);
	} catch (WebDriverException e) {
			} catch (IOException e) {
		
	}
}

//Alert
protected static void confirmalert() {
		Alert confirm= driver.switchTo().alert();
		System.out.println(confirm.getText());
				confirm.dismiss();
				}

//getattributevalue
protected static void attributevalue(WebElement element,String text) {
	try { 
		String val = element.getAttribute(text);
		System.out.println("Get Attribute Value: "+val);
	} catch (Exception e) {
		Assert.fail("Error:Occur During the Url launching");
	}
}


protected static void getOptionsMethod(WebElement element) {
//	Set<String> windowHandles = driver.getWindowHandles();
//    System.out.println(windowHandles);

	Select select = new Select(element);
    boolean multiple = select.isMultiple();
    System.out.println(multiple);
    List<WebElement> options = select.getOptions(); // Fetch all options
    for (WebElement option : options) {
        System.out.println(option.getText()); // Print the visible text of each option
    }
}
protected static void scrollToElement(WebElement element,String type) {
	try {
		if (type.equalsIgnoreCase("viewelement")) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].scrollIntoView(true);", element);
}else if (type.equalsIgnoreCase("click")) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].click();", element);
}
	} catch (Exception e) {
		Assert.fail("Error : can't Scroll");
	}	
}
protected static void actions(WebElement element,String type) {
	try {
		Actions move = new Actions(driver);
		if (type.equalsIgnoreCase("click")) {
			move.click(element).perform();
		}else if (type.equalsIgnoreCase("doubleclick")) {
			move.doubleClick(element).perform();
		}else if (type.equalsIgnoreCase("rightclick")) {
			move.contextClick(element).perform();;
		}else if (type.equalsIgnoreCase("hold")) {
			move.clickAndHold(element).perform();;
		}else if (type.equalsIgnoreCase("release")) {
			move.release(element).perform();
		}else if (type.equalsIgnoreCase("move")) {
			move.moveToElement(element).perform();
		}
	} catch (Exception e) {
		Assert.fail("Error: Invalid Options");
	}
	
}

protected static void backspace(WebElement element) {
	try {
		element.click();
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_A);
		rbt.keyPress(KeyEvent.VK_DELETE);

	} catch (AWTException e) {
		e.printStackTrace();
	}
}

protected static void fileUload(WebElement element,String filepath) {
	try {
        element.click();
		Robot robot = new Robot();
		robot.delay(2000);
		StringSelection ss = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);

	} catch (AWTException e) {
		e.printStackTrace();
	}
}


protected static void validation(WebElement actual,String expected) {
	try {
		Assert.assertEquals(actual.getText(),expected);
		System.out.println(actual.getText());
		
	} catch (Exception e) {
		Assert.fail("Error:Occur During Validation");
	}
	
}
public static void extentReportStart(String location) {
	extentReports = new ExtentReports();
	file=new File(location);
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
	extentReports.attachReporter(sparkReporter);
	extentReports.setSystemInfo("OS",System.getProperty("os.name"));
	extentReports.setSystemInfo("JaVa Version", System.getProperty("java.version"));
}
public static void extentReportTearDown(String location) throws IOException {
	extentReports.flush();
	file=new File(location);
    Desktop.getDesktop().browse((file).toURI());
}
public String takeScreenshot()throws IOException{
	    TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyymmdd_HHmmss").format(new Date());
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("Screenshot\\.png" + "_" + timeStamp + ".png");
		FileHandler.copy(scrfile, destfile);
		return destfile.getAbsolutePath();
	
}
}

