package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RetailHomePOM {
 private WebDriver driver; 
 private Actions accountSelect;
 
	
	public RetailHomePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
		}
	
	@FindBy(xpath="//*[@id=\'Menu_Wmt3OMY3\']/nav/ul/li[2]/a/span")
	private WebElement account; 
	
	@FindBy(xpath="//*[@id=\'Menu_Wmt3OMY3\']/nav/ul/li[2]/ul/li[1]")
	private WebElement loginRegister;
	
	@FindBy(linkText="Nam sed")
	private WebElement productName;
	
	public void selectProduct() throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,1000)");
	 WebDriverWait wait = new WebDriverWait(driver, 2000);
	 wait.until(ExpectedConditions.visibilityOf(productName));
		 
	  productName.isEnabled();
	 productName.click();
	}

	public void GotoLoginPage() //this fuction is to Navigate to Login/Register page.
	{
		accountSelect=new Actions(driver);
		accountSelect.moveToElement(account).build().perform();
		loginRegister.click();
	}
	
	
}
