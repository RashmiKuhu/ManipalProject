package com.training.pom;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutGuestPOM {
	
private WebDriver driver; 
		public CheckoutGuestPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

}

//Guest User
@FindBy(id="input-payment-firstname")
private WebElement firstNamePmt;

@FindBy(id="input-payment-lastname")
private WebElement lastNamePmt;

@FindBy(id="input-payment-email")
private WebElement eMailPmt;

@FindBy(id="input-payment-telephone")
private WebElement telephonePmt;

@FindBy(id="input-payment-address-1")
private WebElement addressOnePmt;

@FindBy(name="address_2")
private WebElement addressTwoPmt;

@FindBy(id="input-payment-city")
private WebElement cityPmt;

@FindBy(id="input-payment-postcode")
private WebElement postcodePmt;

@FindBy(id="input-payment-country")
private WebElement countryPmt;

@FindBy(id="input-payment-zone")
private WebElement statePmt;

@FindBy(xpath="//input[@type='checkbox']")
private WebElement shippingAddress; 

@FindBy(id="button-guest")
private WebElement continueBtnGuest;

@FindBy(xpath="//input[@name='shipping_method']")
private WebElement freeShippingGuest;

@FindBy(xpath="//textarea[@name='comment']")
private WebElement textAreaGuest;

@FindBy(id="button-shipping-method")
private WebElement continueBtnDelMtd;

@FindBy(xpath="//input[@name='agree']")
private WebElement agreeCheckGuest;

@FindBy(xpath="//input[@id='button-payment-method']")
private WebElement continuePayGuest;

@FindBy(xpath="//*[@id=\"accordion\"]/div[6]/div[1]/h4/a")
private WebElement orderConfirnmationGuest;

@FindBy(xpath="//input[@id='button-confirm']")
private WebElement confirmOrderBtn;



public void populateCustomerDetails(String fistName,String lastName,String eMail,String telePhone,String addressOne,String addressTwo,String city,String postCode,String country,String state,String password, String confirmPassword )
{
	this.firstNamePmt.clear();
	this.firstNamePmt.sendKeys(fistName);
	
		
	this.lastNamePmt.clear();
	this.lastNamePmt.sendKeys(lastName);
	 
	this.eMailPmt.clear();
	this.eMailPmt.sendKeys(eMail);
	
	this.telephonePmt.clear();
	this.telephonePmt.click();
	this.telephonePmt.sendKeys(telePhone);
	
	this.addressOnePmt.clear();
	this.addressOnePmt.sendKeys(addressOne);
	
	this.addressTwoPmt.clear();
	this.addressTwoPmt.sendKeys(addressTwo);
    
	this.cityPmt.clear();
	this.cityPmt.sendKeys(city);
  
	this.postcodePmt.clear();
	this.postcodePmt.sendKeys(postCode);
	
	Select contryDropdown = new Select(this.countryPmt);
	contryDropdown.selectByVisibleText(country);
	
	Select stateDropdown = new Select(this.statePmt);
	stateDropdown.selectByVisibleText(state);
}

 public void clickDeliverycheck()
 {  
	 //shippingAddress.sendKeys(Keys.SPACE);
      	 
		
    Assert.assertTrue(shippingAddress.isSelected());
 
	}
    

//this method is to click free shipping check box and enter text in text area
public void clickContinueBilling() throws Exception
{	
	continueBtnGuest.click();
	
	WebDriverWait wait = new WebDriverWait(driver, 2000);
    wait.until(ExpectedConditions.visibilityOf(freeShippingGuest));
    freeShippingGuest.isEnabled();       //checking if terms and condition check box is enabled
    freeShippingGuest.click();	
    Assert.assertTrue(freeShippingGuest.isSelected());
	Assert.assertTrue(textAreaGuest.isDisplayed());
	Assert.assertTrue(textAreaGuest.isEnabled());
	}

// this method is to add comments
public void addComments()
{
	textAreaGuest.sendKeys("This product is nice");
	continueBtnDelMtd.click();
	 	
}	

//checking if terms and condition check box is enabled
public void clickAgreeCheck()
	{
		WebDriverWait wait = new WebDriverWait(driver, 2000);
	    wait.until(ExpectedConditions.visibilityOf(agreeCheckGuest));
	    agreeCheckGuest.isEnabled();       //checking if terms and condition check box is enabled
	    agreeCheckGuest.click();	
	     Assert.assertTrue(agreeCheckGuest.isSelected());
	}
  

//this method is to click continue button
public void clickContinuePayment()
{
	continuePayGuest.click();
	String expectedTitle="Step 6: Confirm Order";
	Assert.assertEquals(orderConfirnmationGuest.getText(), expectedTitle);
}

//this method is to click confirm order button
public void clickOrderConfirmation()
{
	confirmOrderBtn.click();
   	
}


}

