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
import com.training.pom.AddToCart;
import com.training.pom.LoginRegisterPOM;
import com.training.pom.MyOrder;
import com.training.pom.OrderConfirmationPOM;
import com.training.pom.OrderFinalizePOM;
import com.training.pom.OrderHistory;
import com.training.pom.RegisterUserPOM;
import com.training.pom.ConfirmLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class OrderDetailsTest {
		
private WebDriver driver;
private String baseUrl;
private RetailHomePOM retailHomePOM;
private LoginRegisterPOM loginRegisterPOM;
private RegisterUserPOM registeUserPOM;
private ConfirmLoginPOM confirmLoginPOM;
private AddToCart addToCart;
private OrderFinalizePOM orderFinalizePOM;
private OrderConfirmationPOM orderConfirmationPOM;
private MyOrder myOrder;
private OrderHistory orderHistory;
private String customerName;
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
	loginRegisterPOM = new LoginRegisterPOM(driver);
	registeUserPOM = new RegisterUserPOM(driver);
	confirmLoginPOM = new ConfirmLoginPOM(driver);
	addToCart = new AddToCart(driver);
	orderFinalizePOM = new OrderFinalizePOM(driver);
	orderConfirmationPOM = new OrderConfirmationPOM(driver);
	myOrder = new MyOrder(driver);
	orderHistory = new OrderHistory(driver);
	screenShot = new ScreenShot(driver); 
	driver.get(baseUrl); 	// open the browser
  
// Below steps are to Navigate to Account and go to Login/Register Page ,Registering user with provided value, Going to Home page and selecting the product , Add the product to Cart and then place Order.				
	 retailHomePOM.GotoLoginPage();
	 loginRegisterPOM.clickRegisterBtn();
	 registeUserPOM.populateUser("Kuhu1", "Singh", "kuhu12@gmail.com", "2345676709","kadugodi", "Kannamangala", "bangalore","560067","India","Karnataka");
	 confirmLoginPOM.validateConfirmationMsg();
	 confirmLoginPOM.GotoHomePage();
	 confirmLoginPOM.selectProduct();
	 addToCart.clickAddToCart();
	 addToCart.clickCheckOut();
	 orderFinalizePOM.finalizeOrder();
	 orderConfirmationPOM.confirmOrder();
			
}
		
 
 @Test 
   public void ValidateOrder() //This test case is to validate Order history 

  
 {
	 orderConfirmationPOM.GotoMyOrders();
	 screenShot.captureScreenShot("OrderHistory1_RTTC_004");
	 myOrder.copyOrderId();
	 myOrder.checkStatus();
	 myOrder.clickViewIcon();
	 screenShot.captureScreenShot("OrderHistory2_RTTC_004");
	 orderHistory.validateOrderHistory();
	 	 
 }
}
