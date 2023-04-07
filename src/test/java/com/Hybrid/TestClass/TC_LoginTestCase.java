package com.Hybrid.TestClass;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hybrid.javaPageClass.DashboardPageObjectClass;
import com.hybrid.javaPageClass.LoginPageObjectClass;
import com.hybrid.javaPageClass.MainPageObjectClass;


@Listeners(com.Hybrid.Utilities.ExtentListenerClass.class)
public class TC_LoginTestCase extends BaseClass {
	
	@Test(priority = 1,description ="Login Functionality Test Case")
	public void Login() throws InterruptedException {
		
		driver.get(url);
 		logger.info("url is entered");
		driver.manage().deleteAllCookies();
    	logger.info("Cookies deleted");
		driver.manage().window().maximize();
	    logger.info("Window is maximized");
		
		MainPageObjectClass m=new MainPageObjectClass(driver);
		m.ClickOnLoginBtn();
		logger.info("Main Page Login button is clicked");
		Thread.sleep(1000);
		
		LoginPageObjectClass l=new LoginPageObjectClass(driver);
		l.EnterCred("akashbabar14@gmail.com","Akash@14");
		logger.info("Credentials are entered");
		
		l.AccountLogin();
		logger.info("Clicked on Login button");
		Thread.sleep(2000);
		 
		DashboardPageObjectClass d=new DashboardPageObjectClass(driver);
		d.ClickonLogoutbtn(); 
		logger.info("Clicked on logout button");
		Thread.sleep(2000);
		
	}
	

}
