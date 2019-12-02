package com.training.pom;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class OrderFinalizePOM {
	
private WebDriver driver; 
		public OrderFinalizePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

}


@FindBy(xpath="//input[@id='button-payment-address']")
private WebElement continueBtnBilling;

@FindBy(xpath="//input[@id='button-shipping-address']")
private WebElement continueBtnDelivery;

@FindBy(xpath="//input[@id='button-shipping-method']")
private WebElement continueBtnDeliMtd;

@FindBy(xpath="//input[@id='button-payment-method']")
private WebElement continueBtnPmt;

@FindBy(xpath="//input[@name='agree']")
private WebElement agreeCheck;

@FindBy(xpath="//input[@id='button-confirm']")
private WebElement confirmOrderBtn;

@FindBy(xpath="//*[@id=\'accordion\']/div[3]/div[1]/h4/a")
private WebElement deliveyDetails;

@FindBy(xpath="//a[@class='accordion-toggle']")
private WebElement billingDetails; 

@FindBy(name="shipping_method")
private WebElement freeShipping;

@FindBy(xpath="//textarea[@name='comment']")
private WebElement textArea; 

@FindBy(xpath="//*[@id=\"accordion\"]/div[6]/div[1]/h4/a ")
private WebElement orderConfirmation;

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

@FindBy(id="//input[@id='input-payment-address-2']")
private WebElement addressTwoPmt;

@FindBy(id="input-payment-city")
private WebElement cityPmt;

@FindBy(id="input-payment-postcode")
private WebElement postcodePmt;

@FindBy(id="input-payment-country")
private WebElement countryPmt;

@FindBy(id="input-payment-zone")
private WebElement statePmt;

@FindBy(xpath="//input[@name='shipping_address']")
private WebElement shippingAddress;


public void validateBillingPage()
{
	String expectedDelivery="Step 2: Billing Details";
	Assert.assertEquals(billingDetails.getText(), expectedDelivery);	
}
public void populateCustomerDetails(String fistName,String lastName,String eMail,String telePhone,String addressOne,String addressTwo,String city,String postCode,String country,String state)
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
     this.shippingAddress.click();
	 Assert.assertTrue(shippingAddress.isSelected());
	 
}

public void clickContinueBilling()
{
	continueBtnBilling.click();
	String expectedDelivery="Step 3: Delivery Details";
	Assert.assertEquals(deliveyDetails.getText(), expectedDelivery);
}

public void validateDeliverySection()
{

}
public void clickContinueDelivery()
{
	continueBtnDelivery.click();
	Assert.assertTrue(freeShipping.isSelected());
	Assert.assertTrue(textArea.isDisplayed());
	Assert.assertTrue(textArea.isEnabled());
	 	
}	


public void validateDeliveryMtd()
{ 	

	
}

public void clickContinueDeliveryMtd()
{
	textArea.sendKeys("This product is nice");
	 continueBtnDeliMtd.click(); 	
   
}

public void clickAgreeCheck()
{
	 agreeCheck.isEnabled();       //checking if terms and condition check box is enabled
     agreeCheck.click();	
     Assert.assertTrue(agreeCheck.isSelected());
}

public void clickContinuePayment()
{
	continueBtnPmt.click();
	String expectedTitle="Step 6: Confirm Order";
	Assert.assertEquals(orderConfirmation.getText(), expectedTitle);
}

public void clickOrderConfirmation()
{
	confirmOrderBtn.click();
   	
}
   public void finalizeOrder()
     {
	     continueBtnBilling.click();   // click on Continue button in Billing Details section.
	     continueBtnDelivery.click();  //click on Continue button in Delivery address Details section.
	     continueBtnDeliMtd.click();   //click on continue button in DeliveryMethod section 
	     agreeCheck.isEnabled();       //checking if terms and condition check box is enabled
	     agreeCheck.click();           // click on the terms and conditions check box
	      continueBtnPmt.click();      // click on the Continue in Payment method section
	      confirmOrderBtn.click();     //click on Confirm Order button in confirmation section.
      }






}