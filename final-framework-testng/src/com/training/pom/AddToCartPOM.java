package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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

//@FindBy(xpath="/html/body/ul/li/div/div/div[1]/h3/");
//private WebElement alertMsg1;


@FindBy(xpath="//h3[@class='heading']//a")
private WebElement shoppingCart;

@FindBy(xpath="//a[contains(text(),'Checkout')]")
private WebElement checkoutBtn;

@FindBy(xpath="/html/body/div/header/div/div/div[3]/div[2]/div/ul/li/div/div/div[1]/table/tbody/tr/td[2]/a")
private WebElement prodName;




@FindBy(xpath="//*[@id=\'cart\']/ul/li/div/div/div[2]/table/tbody/tr[2]/td[2]") 
private WebElement totalAlert;

@FindBy(xpath="//a[contains(text(),'View Cart')]")
private WebElement viewCart;


   public void clickAddToCart() //This method is to click on Add to cart button
      {
	  // Select quantity = new Select(this.quantity);
	   //quantity.selectByVisibleText("1");
	   addToCardBtn.click();
	// }

	//   public void validateAlert() //This method is to Validate the alert message.
	  //   { 
		  // Alert sucessAddToCart= driver.switchTo().alert();
		 // String expectedAlert="Success: You have added Nam sed to your shopping cart!";
		 //  String expectedAlert="Shopping Cart updated!";
		   //sucessAddToCart.getText();
		   //System.out.println(sucessAddToCart.getText());
		   //sucessAddToCart.dismiss();
		   //Assert.assertTrue("User logged in successfully".contains("successfully"));
		   //Assert.assertTrue("Success: You have added Nam sed to your shopping cart!".contains("Success"));
		 // Assert.assertEquals(alertTitle.getText(), expectedAlert);
		   
	   
	   }
   public void clickViewCart()
   {
	   viewCart.click();
  // }


    }
   
   public void clickShoppingCart()
   {
	   Actions cartSelect=new Actions(driver);
		  cartSelect.moveToElement(shoppingCart).build().perform();
		  
   }
   
   public void clickCheckOut()  //this method  is to click on the checkout button. 
   {   
	  Actions cartSelect=new Actions(driver);
	  cartSelect.moveToElement(shoppingCart).build().perform();
	  checkoutBtn.click();
   }
  
   public String getProductName()      
   { 
	   String prodName=prodNameSelected.getText();
	   return prodName;
   }
   
   public String getPrice()
    {
	   String unitPrice=price.getText();
	   return unitPrice;
    }
   
   public String getQuantity()
   {
	   String quantityReturn=quantity.getText();
	   return quantityReturn;
   }
   public String getModelName()
   {
	   String modelNameReturn=prodNameSelected.getText();
	   return modelNameReturn;
	      }
   
   
   public void validateCart()
   {
	   String expectedProdName=prodNameSelected.getText();
	   System.out.println(prodName.getText());
	   Assert.assertEquals(prodName.getText(), expectedProdName);
	   
	   
   }

   
}
