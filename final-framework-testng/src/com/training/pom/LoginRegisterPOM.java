package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(id="input-email")
	private WebElement eMail;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginBtn;
	
	
	
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
	
}


