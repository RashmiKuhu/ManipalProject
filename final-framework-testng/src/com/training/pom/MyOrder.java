package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class MyOrder {

private WebDriver driver; 
		
public MyOrder(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);

		}

			
@FindBy(xpath="//tr[1]//td[7]//a[1]")
private WebElement displayIcon;
		
@FindBy(xpath="//*[@id=\'System_mY98YHaM\']/div[1]/table/tbody/tr/td[1]")
private WebElement orderIdNum;
		
@FindBy(xpath="//*[@id=\'System_mY98YHaM\']/div[1]/table/tbody/tr/td[4]")
private WebElement status;
	
//This method is to copy oder id
public String copyOrderId()
	{
			String orderId=orderIdNum.getText();
			return orderId;
				}
		
// this method is to click on view Icon
public void clickViewIcon()
		{ 
			
			displayIcon.click();
			
		}
		
// this method is to check status
public void checkStatus()
		{
			String expectedStatus="Pending";
			Assert.assertEquals(status.getText(), expectedStatus);
			
		}
		          		
	        
		
}
