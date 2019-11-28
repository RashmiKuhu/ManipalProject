package com.training.simple.tests;
import com.training.pom.RetailHomePOM;

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
import com.training.pom.ConfirmLoginPOM;
import com.training.pom.ForgotPasswordPOM;
import com.training.pom.LoginRegisterPOM;
import com.training.pom.MyAccountPOM;
import com.training.pom.RegisterUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class LoginTest {

private WebDriver driver;
private String baseUrl;
private LoginRegisterPOM loginRegisterPOM;
private RetailHomePOM retailHomePOM;
private MyAccountPOM myAccountPOM;
private ForgotPasswordPOM forgotPasswordPOM;
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
    	    myAccountPOM = new MyAccountPOM(driver);
    	    forgotPasswordPOM = new ForgotPasswordPOM(driver);
		    screenShot = new ScreenShot(driver); 
	 		driver.get(baseUrl); 	// open the browser
     		retailHomePOM.GotoLoginPage();
     		
		}
	
@AfterMethod
	
	public void tearDown() throws Exception {
		Thread.sleep(1000);
	 driver.quit();
	}
	

//This test case is to Login into application with provided user id and password
@Test
	public void UserLoginTest()
	{
		loginRegisterPOM.userDetails("Reshu123@gmail.com","reshu123");
		loginRegisterPOM.clickLoginBtn();
		myAccountPOM.validateConfirmationMsg();
		screenShot.captureScreenShot("MyAccountPage_RTTC_002");
		
		}
	
	
}
