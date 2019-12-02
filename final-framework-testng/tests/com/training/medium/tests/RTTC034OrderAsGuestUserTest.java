package com.training.medium.tests;
import com.training.pom.RetailHomePOM;
import com.training.pom.ShoppingCartPOM;
import com.training.pom.AddToCartPOM;
import com.training.pom.CheckoutGuestPOM;
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

import com.training.dataproviders.LoginDataProviders;
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

	public class RTTC034OrderAsGuestUserTest  {
		
	private WebDriver driver;
	private String baseUrl;
	private RetailHomePOM retailHomePOM;
	private LoginRegisterPOM loginRegisterPOM;
	private CheckoutOptions checkoutOptions;
	private CheckoutGuestPOM checkoutGuestPOM;
	private OrderConfirmationPOM orderConfirmationPOM;
	private AddToCartPOM addToCartPOM;
	private ShoppingCartPOM shoppingCartPOM;
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
			checkoutGuestPOM = new CheckoutGuestPOM(driver);
			screenShot = new ScreenShot(driver); 
		   	driver.get(baseUrl); 	
		   	   	
			
		}
		
		//@AfterMethod
		//public void tearDown() throws Exception {
			//driver.quit();
		//}
	 
	@Test (dataProvider = "xls-inputs", dataProviderClass = LoginDataProviders.class)
	public void OrderAsGuestUser(String firstName,String lastName,String eMail,String telephone,String address,String extraAddress,String city,String postCode,String country,String state ) throws Exception
	{
		retailHomePOM.selectProduct();
		addToCartPOM.clickAddToCart();
		//addToCartPOM.validateAlert();
		String quantity =addToCartPOM.getQuantity();
		System.out.println(quantity);
		String productName=addToCartPOM.getProductName();
		String modelname=addToCartPOM.getModelName();
		String unitPrice=addToCartPOM.getPrice();
		String total=unitPrice;
	 	 
		addToCartPOM.clickShoppingCart();
		//addToCartPOM.validateCart();
		addToCartPOM.clickViewCart();
		//shoppingCartPOM.validateModelName(modelname, productName, unitPrice, quantity, total);
		shoppingCartPOM.clickCheckOutBtn();
		checkoutOptions.validateLoginPage();
		checkoutOptions.selectGuestUser();
		checkoutOptions.clickContinue();
		checkoutGuestPOM.populateCustomerDetails(firstName, lastName, eMail, telephone, address, extraAddress, city, postCode, country, state);
		checkoutGuestPOM.clickDeliverycheck();
	checkoutGuestPOM.clickContinueBilling();
	checkoutGuestPOM.addComments();
	checkoutGuestPOM.clickAgreeCheck();
	checkoutGuestPOM.clickContinuePayment();
	checkoutGuestPOM.clickOrderConfirmation();
				
		screenShot.captureScreenShot("OrderCompletionAsGuest");
			
	}

	}

	

