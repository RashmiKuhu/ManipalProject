package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AdminLoginPOM {


private WebDriver driver; 
		
public AdminLoginPOM(WebDriver driver) {
     	this.driver = driver; 
		PageFactory.initElements(driver, this);
			
		} 

@FindBy(id="input-username")
private WebElement userName;

@FindBy(id="input-password")
private WebElement passWord;

@FindBy(xpath="//button[@class='btn btn-primary']")
private WebElement loginBtn;

@FindBy(xpath="//h1[@class='panel-title']")
private WebElement loginPage;

public void loginToAdmin(String userName,String passWord)
{
  this.userName.clear();
  this.userName.sendKeys(userName);
  
  this.passWord.clear();
  this.passWord.sendKeys(passWord);
  
  loginBtn.click();
}

public void validateLoginPage()
{
	String expectedLogin="Please enter your login details.";
	  Assert.assertEquals(loginPage.getText(), expectedLogin);	
}

}
