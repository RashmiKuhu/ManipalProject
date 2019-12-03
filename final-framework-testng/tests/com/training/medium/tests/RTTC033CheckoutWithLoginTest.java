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
import com.training.pom.MyAccountPOM;
import com.training.pom.MyOrder;
	import com.training.pom.OrderConfirmationPOM;
	import com.training.pom.OrderFinalizePOM;
	import com.training.pom.OrderHistory;
	import com.training.pom.RegisterUserPOM;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

public class RTTC033CheckoutWithLoginTest  {
		
private WebDriver driver;
private String baseUrl;
private RetailHomePOM retailHomePOM;
private LoginRegisterPOM loginRegisterPOM;
private MyAccountPOM myAccountPOM;
private ConfirmLoginPOM confirmLoginPOM;
private OrderFinalizePOM orderFinalizePOM;
private OrderConfirmationPOM orderConfirmationPOM;
private AddToCartPOM addToCartPOM;
private ShoppingCartPOM shoppingCartPOM;
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
			loginRegisterPOM =new LoginRegisterPOM(driver);
			myAccountPOM =new MyAccountPOM(driver);
			confirmLoginPOM = new ConfirmLoginPOM(driver);
			addToCartPOM = new AddToCartPOM(driver);
			shoppingCartPOM=new ShoppingCartPOM(driver);
			checkoutOptions = new CheckoutOptions(driver);
			orderFinalizePOM = new OrderFinalizePOM(driver);
		  	screenShot = new ScreenShot(driver); 
		   	driver.get(baseUrl); 	
		   	retailHomePOM.GotoLoginPage();
		   	loginRegisterPOM.userDetails("Reshu123@gmail.com","reshu123");
			loginRegisterPOM.clickLoginBtn();
			myAccountPOM.validateConfirmationMsg();
					
		}
		
@AfterMethod
public void tearDown() throws Exception {
	  driver.quit();
	 }
	 

//This method is to createOrder for user who is already logged in to application
@Test 
  public void OrderTestWithLoginLogin() throws Exception
	{
		confirmLoginPOM.GotoHomePage();
		retailHomePOM.selectProduct();
		//confirmLoginPOM.selectProduct();
		addToCartPOM.clickAddToCart();
		
		String quantity =addToCartPOM.getQuantity();
		System.out.println(quantity);
		String productName=addToCartPOM.getProductName();
		String modelname=addToCartPOM.getModelName();
		String unitPrice=addToCartPOM.getPrice();
		String total=unitPrice;
	 
	 	addToCartPOM.clickShoppingCart();
		addToCartPOM.clickViewCart();
	
		//below step is to validate shopping cart page
		shoppingCartPOM.validateModelName(modelname, productName, unitPrice, quantity, total);
		shoppingCartPOM.clickCheckOutBtn();
		
		//below steps are to finalize Order

		orderFinalizePOM.clickContinueBilling();
		orderFinalizePOM.clickContinueDelivery();
		orderFinalizePOM.clickContinueDeliveryMtd();
		orderFinalizePOM.clickAgreeCheck();
		orderFinalizePOM.clickContinuePayment();
		orderFinalizePOM.clickOrderConfirmation();
		orderConfirmationPOM.confirmOrder();		
		screenShot.captureScreenShot("OrderCompletion_RTTC_033");
			
	}

	}

	

