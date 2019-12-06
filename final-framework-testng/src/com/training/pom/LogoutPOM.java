package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LogoutPOM {
private WebDriver driver; 
	
	
	public LogoutPOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
		
	}     

@FindBy(xpath="//p[contains(text(),'You have been logged off your account.)]")
private WebElement logoutMsg;


//This method is to validate logout page
public void validateLogoutMsg()
{ 
	String expectedMsg="You have been logged off your account. It is now safe to leave the computer.";
   Assert.assertEquals(logoutMsg.getText(), expectedMsg);
   //p[contains(text(),'You have been logged off your account. It is now s')]
	
}
}