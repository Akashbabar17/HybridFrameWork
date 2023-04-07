package com.hybrid.javaPageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageObjectClass {
	
	public WebDriver driver;
	
	
	@FindBy(xpath="/html/body/div[1]/div/div[1]/div/div[3]/div/nav/div[2]/div/button")
	WebElement Logout;
	
	public DashboardPageObjectClass(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void ClickonLogoutbtn() {
		Logout.click();
	}

}
