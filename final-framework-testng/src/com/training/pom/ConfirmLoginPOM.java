package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ConfirmLoginPOM {

private WebDriver driver; 
private Actions accountSelect;
	
	public ConfirmLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}

@FindBy(xpath="//p[contains(text(),'Congratulations!')]")
private WebElement messageConfirmation;

@FindBy(xpath="//span[contains(text(),'Home')]")
private WebElement homeLnk;
	
@FindBy(linkText="Nam sed")
private WebElement NamSedProd;

@FindBy(xpath="//*[@id=\'Menu_Wmt3OMY3\']/nav/ul/li[2]/a/span/span")
private WebElement account;

@FindBy(xpath="//span[contains(text(),'LOGOUT')]")
private WebElement logout;
	
	public void validateConfirmationMsg() //this method is to validate the confirmation message for account creation
	{
		 String expectedMsg="Congratulations! Your new account has been successfully created!";
		 Assert.assertEquals(messageConfirmation.getText(), expectedMsg);
		
	}
    
	public void GotoHomePage() //This method is to go to home page
	
	{
		homeLnk.click();
		
	}
	
	public void selectProduct()  //This method is to select product
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1000)");
		 WebDriverWait wait = new WebDriverWait(driver, 2000);
		 wait.until(ExpectedConditions.visibilityOf(NamSedProd));			 
		 NamSedProd.isEnabled();
		 NamSedProd.click();
		
	}
	
	public void logout()
	{
			accountSelect=new Actions(driver);
			accountSelect.moveToElement(account).build().perform();
			logout.click();
		}
		//span[contains(text(),'LOGOUT')]
	}
	
	
	

