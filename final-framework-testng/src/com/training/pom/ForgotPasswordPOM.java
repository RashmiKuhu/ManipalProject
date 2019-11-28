package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class ForgotPasswordPOM {

private WebDriver driver; 
	
	public ForgotPasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(xpath="//legend[contains(text(),'Your E-Mail Address')]")
	private WebElement msgForgotPwdPage;
	
	@FindBy(name="email")
	private WebElement eMail;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement continueBtn;
	
	
	public void PopulateEmail(String eMail)
	
	{
		this.eMail.clear();
		this.eMail.sendKeys(eMail);
		
	}
	
	public void clickContinueBtn()
	{
		continueBtn.click();	
	}
	
}
