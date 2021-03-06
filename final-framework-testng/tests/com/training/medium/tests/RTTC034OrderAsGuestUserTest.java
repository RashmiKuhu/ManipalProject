package com.training.medium.tests;
import com.training.pom.RetailHomePOM;
import com.training.pom.ShoppingCartPOM;
import com.training.pom.AddToCartPOM;
import com.training.pom.CheckoutGuestPOM;
import com.training.pom.CheckoutOptions;
import com.training.pom.ConfirmLoginPOM;
import com.training.pom.GuestOrderConfirmationPOM;

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
	private CheckoutOptions checkoutOptions;
	private CheckoutGuestPOM checkoutGuestPOM;
	private AddToCartPOM addToCartPOM;
	private ShoppingCartPOM shoppingCartPOM;
	private GuestOrderConfirmationPOM guestOrderConfirmationPOM;
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
			guestOrderConfirmationPOM = new GuestOrderConfirmationPOM(driver);
			screenShot = new ScreenShot(driver); 
		   	driver.get(baseUrl); 	
		   	
		}
		
@AfterMethod
   public void tearDown() throws Exception {
	  driver.quit();
		}

//To verify whether application allows user to place an order as guest user
@Test (dataProvider = "xls-inputs", dataProviderClass = LoginDataProviders.class)
	public void OrderAsGuestUser(String rowNumber,String firstName,String lastName,String eMail,String telephone,String address,String extraAddress,String city,String postCode,String country,String state , String password,String confirmPassword ) throws Exception
	{
		retailHomePOM.selectProduct();
		addToCartPOM.clickAddToCart();
		
		//below steps are to store values from Add to Cart page 
		String quantity =addToCartPOM.getQuantity();
		System.out.println(quantity);
		String productName=addToCartPOM.getProductName();
		String modelname=addToCartPOM.getModelName();
		String unitPrice=addToCartPOM.getPrice();
		String total=unitPrice;
	 	 
		addToCartPOM.clickShoppingCart();
		addToCartPOM.clickViewCart();
		
		// below steps are to validate shopping cart
		shoppingCartPOM.validateModelName(modelname, productName, unitPrice, quantity, total);
		shoppingCartPOM.clickCheckOutBtn();
		
		//below steps are to finalize order
		checkoutOptions.validateLoginPage();
		checkoutOptions.selectGuestUser();
		checkoutOptions.clickContinue();
	
		//populating customer details using dataProvider
		
		checkoutGuestPOM.populateCustomerDetails(rowNumber,firstName, lastName, eMail, telephone, address, extraAddress, city, postCode, country, state,password,confirmPassword);
		checkoutGuestPOM.clickDeliverycheck();
	    checkoutGuestPOM.clickContinueBilling();
	    checkoutGuestPOM.addComments();
	    checkoutGuestPOM.clickAgreeCheck();
	    checkoutGuestPOM.clickContinuePayment();
	    checkoutGuestPOM.clickOrderConfirmation();
	    guestOrderConfirmationPOM.confirmOrder();
				
		screenShot.captureScreenShot("OrderCompletionAsGuest_RTTC_034");
			
	}

	}

	

