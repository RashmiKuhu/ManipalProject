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



   public void clickAddToCart()
      {
	   addToCardBtn.click();
	   
      }

   public void validateAlert()
   
   { 
	   Alert sucessAddToCart= driver.switchTo().alert();
	   String expectedAlert="Success: You have added lacinia congue to your shopping cart!";
	   sucessAddToCart.accept();
	   Assert.assertEquals(alertMsg.getText(), expectedAlert);
	   
   }
   
   public void clickCheckOut()
   {   
	  Actions cartSelect=new Actions(driver);
	  cartSelect.moveToElement(shoppingCart).build().perform();
	  checkoutBtn.click();
   }
  


}
