package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class OrderHistory {
private WebDriver driver; 
		
    public OrderHistory(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);

	}
    
@FindBy(xpath="//*[@id=\'PageTitleSystem_B083XYxw\']/h1")
private WebElement pageTitle;

    
	public void validateOrderHistory()
	{
		String expectedTitle="Order Information";
		Assert.assertEquals(pageTitle.getText(), expectedTitle);
      		
	}
}
