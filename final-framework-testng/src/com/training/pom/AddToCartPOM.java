package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddToCartPOM {
	
private WebDriver driver; 
		public AddToCartPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

	}
	
@FindBy(xpath="//*[@id=\"ProductInfoSystem_IcyE9WlD\"]/dl/dd[2]")
private WebElement prodNameSelected;

@FindBy(name="quantity")
private WebElement quantity;

@FindBy(xpath="//div[@class='price']//span[@class='price-regular']")
private WebElement price;

@FindBy(xpath="//li[@class='mSSlide active']//img")
private WebElement image;

@FindBy(xpath="//button[@id='button-cart']")
private WebElement addToCardBtn;

@FindBy(xpath="//ul[@class='noty_cont noty_layout_topRight']")
private WebElement alertMsg;

@FindBy(className="tb_icon tb_main_color_bg")
private WebElement alertMsg1;

@FindBy(xpath="//h3[@class='heading']//a")
private WebElement shoppingCart;

@FindBy(xpath="//a[contains(text(),'Checkout')]")
private WebElement checkoutBtn;

@FindBy(xpath="//div[@class='mini-cart-info cart-info']//a[contains(text(),'Nam sed')]")
private WebElement prodName;

@FindBy(xpath="//h3[contains(text(),'Shopping Cart')]")
private WebElement shoingCart;

@FindBy(xpath="//*[@id=\'cart\']/ul/li/div/div/div[2]/table/tbody/tr[2]/td[2]") 
private WebElement totalAlert;

@FindBy(xpath="//a[contains(text(),'View Cart')]")
private WebElement viewCart;


   public void clickAddToCart() //This method is to click on Add to cart button
      {
	  	   addToCardBtn.click();
      }

  public void clickViewCart() // This method is to click on viewCart 
      {   
	     WebDriverWait wait = new WebDriverWait(driver, 2000);
	     wait.until(ExpectedConditions.visibilityOf(viewCart));
	     viewCart.click();
       }
   
   public void clickShoppingCart() // This method is to mouseover on the Shoping cart
    { WebDriverWait wait = new WebDriverWait(driver, 2000);
    wait.until(ExpectedConditions.visibilityOf(shoppingCart));
	   Actions cartSelect=new Actions(driver);
		  cartSelect.moveToElement(shoppingCart).build().perform();
		  
    }
   
   public void clickCheckOut()  //this method  is to click on the checkout button. 
   {   
	  	  checkoutBtn.click();
   }
  
   public String getProductName()      //This method to return product name
     { 
	   String prodName=prodNameSelected.getText();
	   return prodName;
     }
   
   public String getPrice()  //This method to return price
    {
	   String unitPrice=price.getText();
	   return unitPrice;
    }
   
   public String getQuantity()  //This method is to return quantity
      {
	   String quantityReturn=quantity.getText();
	   return quantityReturn;
   }
   
   public String getModelName() //This method is to return model name
   {
	   String modelNameReturn=prodNameSelected.getText();
	   return modelNameReturn;
	      }
   
   
   
   
}
