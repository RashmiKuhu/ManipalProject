package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AdminDashBoardPOM {
private WebDriver driver; 
private Actions catalog;
private Actions customer;
	
public  AdminDashBoardPOM(WebDriver driver) {
	     	this.driver = driver; 
			PageFactory.initElements(driver, this);
				
		} 

@FindBy(xpath="//h1[contains(text(),'Dashboard')]")
private WebElement dashboardVisible;

@FindBy(xpath="//*[@id='menu-catalog']/a/i")
private WebElement catalogIcon;

@FindBy(xpath="//a[contains(text(),'Categories')]")
private WebElement categoryLink;

@FindBy(xpath="//*[@id=\'menu-customer\']/a/i")
private WebElement customerIcon;

@FindBy(xpath="//*[@id=\'menu-customer\']/ul/li[1]/a")
private WebElement customersLink;


//This method is to check if dashboad is visible
public void dashBoardVisible()
{
  String expectedDashboard="Dashboard";
  Assert.assertEquals(dashboardVisible.getText(), expectedDashboard);
		  
}

//This method is to navigate to category page

public void navigateToCategories()
{
	catalog= new Actions(driver);
	catalog.moveToElement(catalogIcon).build().perform();
	
	categoryLink.click();
	
	}

//This method is to navigate to Customer
public void navigateToCustomers()
{
	customer= new Actions(driver);
	customer.moveToElement(customerIcon).build().perform();
	customersLink.click();
}
}

