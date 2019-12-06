package com.training.simple.tests;

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

import com.training.pom.RetailHomePOM;
import com.training.pom.AddToCartPOM;
import com.training.pom.LoginRegisterPOM;
import com.training.pom.LogoutPOM;
import com.training.pom.MyAccountPOM;
import com.training.pom.MyOrder;
import com.training.pom.OrderConfirmationPOM;
import com.training.pom.OrderFinalizePOM;
import com.training.pom.OrderHistory;
import com.training.pom.RegisterUserPOM;
import com.training.pom.ConfirmLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC004OrderDetailsTest {
		
private WebDriver driver;
private String baseUrl;
private RetailHomePOM retailHomePOM;
private LoginRegisterPOM loginRegisterPOM;
private MyAccountPOM myAccountPOM;
private AddToCartPOM addToCart;
private OrderFinalizePOM orderFinalizePOM;
private OrderConfirmationPOM orderConfirmationPOM;
private MyOrder myOrder;
private OrderHistory orderHistory;
private static Properties properties;
private ScreenShot screenShot;
private String userName;
private String passWord;
		

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
	userName= properties.getProperty("username");
	passWord=properties.getProperty("password");
	retailHomePOM = new RetailHomePOM(driver);
	loginRegisterPOM = new LoginRegisterPOM(driver);
	myAccountPOM= new MyAccountPOM(driver);
	addToCart = new AddToCartPOM(driver);
	orderFinalizePOM = new OrderFinalizePOM(driver);
	orderConfirmationPOM = new OrderConfirmationPOM(driver);
	myOrder = new MyOrder(driver);
	orderHistory = new OrderHistory(driver);
	screenShot = new ScreenShot(driver); 
	driver.get(baseUrl); 	// open the browser
  
// Below steps are to Navigate to Account and go to Login/Register Page ,Registering user with provided value, Going to Home page and selecting the product , Add the product to Cart and then place Order.				
	 retailHomePOM.GotoLoginPage();
	 loginRegisterPOM.userDetails(userName,passWord);  
	 loginRegisterPOM.clickLoginBtn();
	 myAccountPOM.validateConfirmationMsg();
	 
	 //below steps are to create order for customer who has already logged in
	 myAccountPOM.GotoHomePage();
	 retailHomePOM.selectProduct();
	 addToCart.clickAddToCart();
	 addToCart.clickShoppingCart();
	 addToCart.clickCheckOut();
	 orderFinalizePOM.clickContinueBilling();
	 orderFinalizePOM.clickContinueDelivery();
	 orderFinalizePOM.clickContinueDeliveryMtd();
     orderFinalizePOM.clickAgreeCheck();
	 orderFinalizePOM.clickContinuePayment();
	 orderFinalizePOM.clickOrderConfirmation();
	 orderConfirmationPOM.confirmOrder();
			
}
		
//@AfterMethod

  // public void tearDown() throws Exception {

    // driver.quit();
   //}
 
 @Test (groups= {"simple"})
   public void ValidateOrder() //This test case is to validate Order history 
  {
	 orderConfirmationPOM.GotoMyOrders();
	 screenShot.captureScreenShot("OrderHistory1_RTTC_004_1");
	 myOrder.copyOrderId();
	 myOrder.checkStatus();
	 myOrder.clickViewIcon();
	 screenShot.captureScreenShot("OrderHistory2_RTTC_004_2");
	 orderHistory.validateOrderHistory();
	 	 
 }
}
