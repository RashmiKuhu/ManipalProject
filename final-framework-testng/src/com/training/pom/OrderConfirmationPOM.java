package com.training.pom;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderConfirmationPOM {
		
private WebDriver driver; 

  public OrderConfirmationPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
     }

//Locating required elements.
  
@FindBy(xpath="//*[@id=\'System_mY98YHaM\']/div[1]/p[1]")
private WebElement confirmMsg;

@FindBy(xpath="//*[@id=\'Menu_Wmt3OMY3\']/nav/ul/li[2]/a/span")
private WebElement account; 

@FindBy(xpath="//span[contains(text(),'MY ORDERS')]")
private WebElement myOrders;


      public void confirmOrder() // checking confirmation message that order has been processed successfully.
         {
    	  String expectedCnfMsg="Your order has been successfully processed!";

	      Assert.assertEquals(confirmMsg.getText(), expectedCnfMsg);
	    	  			  
         }

      public void GotoMyOrders() //Mouseover on the Account icon and select My Orders from the list.
        {
    	
    	   Actions accountSelect=new Actions(driver);
    	   accountSelect.moveToElement(account).build().perform();
    	   myOrders.click();
	    }
    			
	}
