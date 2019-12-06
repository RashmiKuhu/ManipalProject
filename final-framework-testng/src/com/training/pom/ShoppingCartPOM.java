package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ShoppingCartPOM{
private WebDriver driver; 
	
	public ShoppingCartPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}


@FindBy(xpath="//*[@id=\"cart_form\"]/div/table/tbody/tr/td[1]")
private WebElement image;

@FindBy(xpath="//div[@class='cart-info tb_min_w_500']//tbody//td[@class='name']")
private WebElement productName;

@FindBy(xpath="//*[@id=\"cart_form\"]/div/table/tbody/tr/td[3]")
private WebElement modelName;

@FindBy(xpath="//*[@id=\'cart_form\']/div/table/tbody/tr/td[4]/div/input")
private WebElement quantity;

@FindBy(xpath="//*[@id=\"total\"]/tbody/tr[2]/td[2]")
private WebElement totalFinal;

@FindBy(xpath="//*[@id=\"cart_form\"]/div/table/tbody/tr/td[5]")
private WebElement unitPrice;

@FindBy(xpath="//*[@id=\"cart_form\"]/div/table/tbody/tr/td[6]") 
private WebElement total;

@FindBy(xpath="//a[@class='btn btn-primary']")
private WebElement checkoutBtn;


// This method is to validate Shopping cart data
 public void validateModelName(String modelname,String prodName,String unitPriceCart,String quantityCart,String totalCart)
 {
	 String expectedModelName=modelname;
	 Assert.assertEquals(modelName.getText(), expectedModelName);
	 String expectedProdName=prodName;
	 Assert.assertEquals(productName.getText(), expectedProdName);
	 String expectedunitPrice =unitPriceCart;
	 Assert.assertEquals(unitPrice.getText(), expectedunitPrice);
	 String expectedQuantity=quantityCart;
	 Assert.assertEquals(quantity.getText(), expectedQuantity);
	 String expectedTotal=totalCart;
	 Assert.assertEquals(total.getText(), expectedTotal);
	 Assert.assertEquals(totalFinal.getText(), expectedTotal);
	 	 	 
 }
 
 
 //This method is to click on checkout button 
 
 public void clickCheckOutBtn()
 {
	 checkoutBtn.click();  
 }
  
	  
  }
  
  



