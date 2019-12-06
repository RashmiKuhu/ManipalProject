package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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


public void validateBillingPage() //this method will check Billing section is displayed or not
{
	String expectedDelivery="Step 2: Billing Details";
	Assert.assertEquals(billingDetails.getText(), expectedDelivery);	
}

public void clickContinueBilling()  //this method will click on continue button on Billing section and check if Delivery Details section is displayed or not
{
	continueBtnBilling.click();
	String expectedDelivery="Step 3: Delivery Details";
	Assert.assertEquals(deliveyDetails.getText(), expectedDelivery);
}


public void clickContinueDelivery() // this method will click on Continue button in DeliveryDetail
{
	continueBtnDelivery.click();
	Assert.assertTrue(freeShipping.isSelected());
	Assert.assertTrue(textArea.isDisplayed());
	Assert.assertTrue(textArea.isEnabled());
	 	
}	


public void clickContinueDeliveryMtd() //this method will add comments and click on continue in delivery Method section
{
	textArea.sendKeys("This product is nice");
	 continueBtnDeliMtd.click(); 	
   
}

public void clickAgreeCheck() //this method will click on terms and condition check box
{
	WebDriverWait wait = new WebDriverWait(driver, 2000);
    wait.until(ExpectedConditions.visibilityOf(agreeCheck));
	 agreeCheck.isEnabled();       //checking if terms and condition check box is enabled
     agreeCheck.click();	
     Assert.assertTrue(agreeCheck.isSelected());
}

public void clickContinuePayment() // this method will click on Continue button for Payment section
{
	continueBtnPmt.click();
	String expectedTitle="Step 6: Confirm Order";
	Assert.assertEquals(orderConfirmation.getText(), expectedTitle);
}

public void clickOrderConfirmation()
{
	confirmOrderBtn.click();
   	
}
   

}