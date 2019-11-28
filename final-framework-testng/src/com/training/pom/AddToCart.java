package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddToCart {
	
private WebDriver driver; 
		public AddToCart(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

	}
	
	
@FindBy(xpath="//button[@id='button-cart']")
private WebElement addToCardBtn;

@FindBy(xpath="//ul[@class='noty_cont noty_layout_topRight']")
private WebElement alertMsg;

@FindBy(xpath="//h3[@class='heading']//a")
private WebElement shoppingCart;

@FindBy(xpath="//a[contains(text(),'Checkout')]")
private WebElement checkoutBtn;



   public void clickAddToCart() //This method is to click on Add to cart button
      {
	   addToCardBtn.click();
	   
      }

   public void validateAlert() //This method is to Validate the alert message.
     { 
	   Alert sucessAddToCart= driver.switchTo().alert();
	   String expectedAlert="Success: You have added lacinia congue to your shopping cart!";
	   sucessAddToCart.accept();
	   Assert.assertEquals(alertMsg.getText(), expectedAlert);
	   
    }
   
   public void clickCheckOut()  //this method  is to click on the checkout button. 
   {   
	  Actions cartSelect=new Actions(driver);
	  cartSelect.moveToElement(shoppingCart).build().perform();
	  checkoutBtn.click();
   }
  


}
