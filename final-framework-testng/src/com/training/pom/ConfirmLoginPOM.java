package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class ConfirmLoginPOM {

private WebDriver driver; 
	
	public ConfirmLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//p[contains(text(),'Congratulations!')]")
	private WebElement messageConfirmation;
	
	public void validateConfirmationMsg()
	{
		 String expectedMsg="Congratulations! Your new account has been successfully created!";
		 Assert.assertEquals(messageConfirmation.getText(), expectedMsg);
		
	}

}

