package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginRegisterPOM {
private WebDriver driver; 
	
	
	public LoginRegisterPOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
		
	}          
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
			//"//button[contains(text(),'Register')]")
			//"//*[@id=\'System_nyHsmShk\']/div/div[1]/div/div[2]/div/a") // need to change use contains
	private WebElement registerBtn; 
	
	@FindBy(name="email")
	private WebElement eMail;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement invalideUserWng;
	
	@FindBy(xpath="//a[contains(text(),'Forgotten Password')]")
	private WebElement forgotPassword;
	
	@FindBy(xpath="//*[@id=\"System_nyHsmShk\"]/div[1]")
	private WebElement actConfirmMsg;
	
	
	public void userDetails(String eMail,String password)
	{
		this.eMail.clear();
		this.eMail.sendKeys(eMail);
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void clickRegisterBtn() {
		registerBtn.click(); 
		
}
	public void clickLoginBtn()
	{
		loginBtn.click();
	}
	
	public void validateWarningInvalidPassword(String msg)
	{            //String expectedMsg="Warning: No match for E-Mail Address and/or Password.";
		 		 Assert.assertEquals(invalideUserWng.getText(), msg);
		
	}
	
	public void clickForgotPasswordLnk()
	{
		forgotPassword.click();
	}

	public void validateConfirmationMsg()
	
	{
		String expConfirmationMsg ="An email with a confirmation link has been sent your email address.";
	    Assert.assertEquals(actConfirmMsg.getText(),expConfirmationMsg );	
	}
	
	public void LoginValidation(String eMail,String Password,String msg)
	{
		this.eMail.clear();
		this.eMail.sendKeys(eMail);
		this.password.clear();
		this.password.sendKeys(Password);
		 
	}
}


