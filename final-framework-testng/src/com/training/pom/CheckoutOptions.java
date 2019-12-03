package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckoutOptions {
	
private WebDriver driver; 
		public CheckoutOptions(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

	}

@FindBy(xpath="//a[@class='accordion-toggle']")
private WebElement checkoutOption;

@FindBy(xpath="//div[@id='collapse-checkout-option']//div[2]//label[1]//input[1]")
private WebElement guestUser;
		
@FindBy(xpath="//input[@id='button-account']")
private WebElement continueBtn;

public void validateLoginPage()
{
 String expectedOption="Step 1: Checkout Options";
 Assert.assertEquals(checkoutOption.getText(), expectedOption);
}

public void selectGuestUser()
{
	guestUser.click();
  
}

public void clickContinue()
{
	continueBtn.click();
}
}
