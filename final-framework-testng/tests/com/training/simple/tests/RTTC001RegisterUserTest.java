package com.training.simple.tests;
import com.training.pom.RetailHomePOM;
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
import com.training.pom.RegisterUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC001RegisterUserTest {
	
private WebDriver driver;
private String baseUrl;
private LoginRegisterPOM loginRegisterPOM;
private RetailHomePOM retailHomePOM;
private static Properties properties;
private ScreenShot screenShot;
private RegisterUserPOM registeUserPOM;
private ConfirmLoginPOM confirmLoginPOM;
	

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
		screenShot = new ScreenShot(driver); 
	   	driver.get(baseUrl); 	// open the browser
        retailHomePOM.GotoLoginPage();     //Mouseover on My Account icon 
		loginRegisterPOM.clickRegisterBtn(); //click on the Register/Login button
	}
 
	
	
  @AfterMethod
	 public void tearDown() throws Exception {
	   		driver.quit();
	}
	
   // This test case is to RegisterUser test register User with given below details.
	@Test(dataProvider = "xls-inputs", dataProviderClass = LoginDataProviders.class)
	public void RegisterUserTest(String firstName,String lastName,String eMail,String telephone,String address,String extraAddress,String city,String postCode,String country,String state,String password,String confirmPassword ) throws Exception
	{
		registeUserPOM.populateUser(firstName,lastName,eMail,telephone,address,extraAddress,city,postCode,country,state,password,confirmPassword);
		confirmLoginPOM.validateConfirmationMsg();
	    screenShot.captureScreenShot("AccountCreated_RTTC_001");
	
	}

	
	
	
	
	
	
	
}
