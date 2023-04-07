package com.Hybrid.TestClass;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Hybrid.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	ReadConfig r=new ReadConfig();
	
	String url=r.getBaseUrl();
	String browser=r.getBrowser();
	
	
	@BeforeClass
	
	public void SetUp() {
		switch(browser.toLowerCase()) {
		
		case"chrome":
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case"firefox":
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
		case"edge":
//			System.setProperty("webdriver.http.factory", "jdk-http-client");
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
		default:
				driver=null;
		
			break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		logger=LogManager.getLogger("HybridFrameWork"); 

	}
	
	
	@AfterClass
	
	public void tearUp() {
		driver.close();
	}
	
	public void captureScreenShot(WebDriver driver, String testName) throws IOException {
		TakesScreenshot ts=((TakesScreenshot)driver);
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"//Screenshot//"+testName+".png");
		FileHandler.copy(src, dest);
		
	}

}






