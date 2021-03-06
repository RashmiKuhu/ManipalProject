package com.training.medium.tests;

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

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.ConfirmLoginPOM;
import com.training.pom.LoginRegisterPOM;
import com.training.pom.RegisterUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RTTC031LoginErrorTest {

private WebDriver driver;
private String baseUrl;
private LoginRegisterPOM loginRegisterPOM;
private RetailHomePOM retailHomePOM;
private static Properties properties;
private ScreenShot screenShot;
	
@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		 
	}
	
@BeforeMethod
public void setUp() throws Exception { //initializing objects and variables
	        driver = DriverFactory.getDriver(DriverNames.CHROME);
			baseUrl = properties.getProperty("baseURL");
			retailHomePOM = new RetailHomePOM(driver);
    	    loginRegisterPOM = new LoginRegisterPOM(driver);
    	    screenShot = new ScreenShot(driver); 
	 		driver.get(baseUrl); 	// open the browser
     		retailHomePOM.GotoLoginPage();
     		
		}
	
@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
	   driver.quit();
	 }
	

//This test case is to Login into application with provided user id and password in the excel sheet
@Test (dataProvider = "xls-Login", dataProviderClass = LoginDataProviders.class)
	public void validateUserLoginTest(String eMail,String password,String msg)
	{  
	
	   loginRegisterPOM.LoginValidation(eMail, password, msg);
	   loginRegisterPOM.clickLoginBtn();
	   loginRegisterPOM.validateWarningInvalidPassword(msg);  //validating  error message
	   screenShot.captureScreenShot("MyAccountPage_RTTC_002");
	   
		}
	
	
}
