package com.training.pom;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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