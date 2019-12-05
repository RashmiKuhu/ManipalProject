package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ErrorRegisterUserPOM {


private WebDriver driver; 
	
	public ErrorRegisterUserPOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
		
	}  
@FindBy(xpath="//*[@id=\'account\']/div[2]/div/div")
private WebElement errorFirstName;

@FindBy(xpath="//*[@id=\'account\']/div[3]/div/div")
private WebElement errorLastName;

@FindBy(xpath="//*[@id=\'account\']/div[4]/div/div")
private WebElement errorEMail;

@FindBy(xpath="//*[@id=\'account\']/div[5]/div/div")
private WebElement errorTelephone;

@FindBy(xpath="//*[@id=\'address\']/div[2]/div/div")
private WebElement errorAddress;

@FindBy(xpath="//*[@id=\'address\']/div[4]/div/div")
private WebElement errorCity;

@FindBy(xpath="//*[@id=\'address\']/div[7]/div/div")
private WebElement errorState;

@FindBy(xpath="//*[@id=\'System_nyHsmShk\']/form/fieldset[3]/div[1]/div/div")
private WebElement errorPassword;

public void validateErrorMsg()
{
	
	
	//
	// WebDriverWait wait = new WebDriverWait(driver, 2000);
	 //wait.until(ExpectedConditions.alertIsPresent());
  //Alert alert= driver.switchTo().alert();

  //String expectedMsg=alert.getText();
  
  //alert.accept();
  
  //Assert.assertTrue(expectedMsg.contains("Please"));
  
}






	
	
}
