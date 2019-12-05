package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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




	
	
}
