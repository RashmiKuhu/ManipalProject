package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GuestOrderConfirmationPOM {
	
private WebDriver driver; 
		public GuestOrderConfirmationPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

}

@FindBy(xpath="//*[@id=\'System_mY98YHaM\']/div[1]/p[1]")
private WebElement confirmMsg;

// this method is confirm order
public void confirmOrder()
{
  String expectedMsg="Your order has been successfully processed!";
  Assert.assertEquals(confirmMsg.getText(), expectedMsg);
}

}



