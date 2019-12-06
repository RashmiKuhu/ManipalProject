package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class OrderHistory {
private WebDriver driver; 
		
    public OrderHistory(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);

	}
    
   
public void validateOrderHistory()
	{
		String expectedTitle="Order Information";
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		
      		
	}
}
