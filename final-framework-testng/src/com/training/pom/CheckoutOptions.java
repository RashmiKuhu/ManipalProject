package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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


// This method is to validate Login page
public void validateLoginPage()
{
 String expectedOption="Step 1: Checkout Options";
 Assert.assertEquals(checkoutOption.getText(), expectedOption);
}

//This method is to select Guest user
public void selectGuestUser()
{
	guestUser.click();
  
}

public void clickContinue()
{
	continueBtn.click();
}
}
