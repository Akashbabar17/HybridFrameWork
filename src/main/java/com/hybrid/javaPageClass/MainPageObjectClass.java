package com.hybrid.javaPageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageObjectClass {
	
	WebDriver driver;
	
	
	
	@FindBy(id="w3loginbtn")
	WebElement MainLogInBtn;
	
	public MainPageObjectClass(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnLoginBtn() {
		MainLogInBtn.click();
	}

}
