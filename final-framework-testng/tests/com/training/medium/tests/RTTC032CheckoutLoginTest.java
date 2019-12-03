package com.training.medium.tests;

import com.training.pom.RetailHomePOM;
import com.training.pom.ShoppingCartPOM;

import com.training.pom.AddToCartPOM;
import com.training.pom.CheckoutOptions;
import com.training.pom.ConfirmLoginPOM;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.LoginRegisterPOM;
import com.training.pom.MyOrder;
import com.training.pom.OrderConfirmationPOM;
import com.training.pom.OrderFinalizePOM;
import com.training.pom.OrderHistory;
import com.training.pom.RegisterUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC032CheckoutLoginTest  {
	
private WebDriver driver;
private String baseUrl;
private AddToCartPOM addToCartPOM;
private ShoppingCartPOM shoppingCartPOM;
private RetailHomePOM retailHomePOM;
private CheckoutOptions checkoutOptions;
private static Properties properties;
private ScreenShot screenShot;
	

@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		 
	}
	
@BeforeMethod
	public void setUp() throws Exception {
    	driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		retailHomePOM = new RetailHomePOM(driver);
		addToCartPOM = new AddToCartPOM(driver);
		shoppingCartPOM=new ShoppingCartPOM(driver);
		checkoutOptions = new CheckoutOptions(driver);
	  	screenShot = new ScreenShot(driver); 
	   	driver.get(baseUrl); 	
           
		}
	
	
@AfterMethod
	public void tearDown() throws Exception {
	driver.quit();
	}
 
// RTTC_032 this test case it to verify whether application displays Login screen upon checking out the product without Pre Logging in
	
@Test
public void OrderTestwithoutLogin() throws Exception
{
	retailHomePOM.selectProduct();
	addToCartPOM.clickAddToCart();
    
	// storing values retreived from Add To Cart page.
	
	String quantity =addToCartPOM.getQuantity();
	String productName=addToCartPOM.getProductName();
	String modelname=addToCartPOM.getModelName();
	String unitPrice=addToCartPOM.getPrice();
	String total=unitPrice;
	
	addToCartPOM.clickShoppingCart(); 
	addToCartPOM.clickViewCart();
	
	// validate shopping cart 
	shoppingCartPOM.validateModelName(modelname, productName, unitPrice, quantity, total); //Validating data in shopping cart with Add to cart page.
	shoppingCartPOM.clickCheckOutBtn();
	checkoutOptions.validateLoginPage();   // 
	screenShot.captureScreenShot("Medium_Order_RTTC_032");
		
}

}
