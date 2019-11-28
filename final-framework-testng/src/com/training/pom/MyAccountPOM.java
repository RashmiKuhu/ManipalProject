package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyAccountPOM {

	 private WebDriver driver; 
	 private Actions accountSelect;
	 
		
		public MyAccountPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
			
			}
	

	@FindBy(xpath="//h2[contains(text(),'My Account')]")
	private WebElement messageAccountPage;
	
	public void validateConfirmationMsg()  //This method is to validate that My Account page is displayed
	{
		 String expectedMsg="My Account";
		 Assert.assertEquals(messageAccountPage.getText(), expectedMsg);
		
	}
}
