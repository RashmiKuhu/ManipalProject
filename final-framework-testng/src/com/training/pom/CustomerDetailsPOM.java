package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CustomerDetailsPOM {
private WebDriver driver; 

	
public  CustomerDetailsPOM(WebDriver driver) {
	     	this.driver = driver; 
			PageFactory.initElements(driver, this);
				
		} 
@FindBy(xpath="//h1[contains(text(),'Customers')]")
private WebElement customersTitle;

@FindBy(id="input-name")
private WebElement customerName;

@FindBy(id="input-email")
private WebElement eMail;

@FindBy(id="button-filter")
private WebElement filterBtn;

@FindBy(xpath="//*[@id=\'form-customer\']/div/table/tbody/tr[1]/td[2]")
private WebElement custName;

@FindBy(xpath="//*[@id=\'form-customer\']/div/table/tbody/tr[1]/td[3]")
private WebElement eMailReturned;

@FindBy(xpath="//*[@id=\'form-customer\']/div/table/tbody/tr[1]/td[4]")
private WebElement CustGroup;

@FindBy(xpath="//*[@id=\'form-customer\']/div/table/tbody/tr[1]/td[5]")
private WebElement enabled;

@FindBy(xpath="//*[@id=\'form-customer\']/div/table/tbody/tr[1]/td[7]")
private WebElement dateAdded;


@FindBy(xpath="//*[@id=\'form-customer\']/div/table/tbody/tr[1]/td[8]/div/button")
private WebElement actionLogintoStore;

@FindBy(xpath="//*[@id=\'form-customer\']/div/table/tbody/tr[1]/td[8]/a")
private WebElement actionEditBtn;

@FindBy(xpath="//*[@id=\'form-customer\']/div/table/tbody/tr[1]/td[1]/input")
private WebElement checkBox;

@FindBy(xpath="//button[@class='btn btn-danger']")
private WebElement deleteBtn;

@FindBy(xpath="//div[@class='alert alert-success']")
private WebElement successMsg;

@FindBy(xpath="//*[@id=\'header\']/ul/li[4]/a/span")
private WebElement logoutBtn;

public void validateCustomersPage()
{
  String expectedMsg="Customers";
  Assert.assertEquals(customersTitle.getText(), expectedMsg);
  
}

public void validateCustomerData(String firstName,String lastName,String eMail,String telephone,String addressOne,String addressTwo,String city,String poctCode,String country,String state,String passWord,String confirmPassWord )
{
   this.customerName.clear();
   this.customerName.sendKeys(firstName+" "+lastName);
   
   this.eMail.clear();
   this.eMail.sendKeys(eMail);
   
   filterBtn.click();
   
   Assert.assertEquals(custName.getText(), firstName+" "+lastName);
   
   Assert.assertEquals(eMailReturned.getText(), eMail);
   
   Assert.assertEquals(CustGroup.getText(), "Default");
   
   Assert.assertEquals(enabled.getText(), "Enabled");
   
   Assert.assertTrue(actionLogintoStore.isEnabled());
   
   Assert.assertTrue(actionEditBtn.isEnabled());
      
}

 public void deleteCustomer()
 {
	checkBox.isEnabled();
	checkBox.click();
	deleteBtn.click();
	
	Alert alert =driver.switchTo().alert();
	String expectedMsg="Are you sure?";
	
	Assert.assertEquals(alert.getText(), expectedMsg);
	
	alert.accept();
	
	Assert.assertTrue(successMsg.getText().contains("Success"));
	
 }
 
 public void logoutAdmin()
 {
	 logoutBtn.click();
	 
 }
	
 

 
}
