package com.training.simple.tests;

import com.training.pom.RetailHomePOM;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.ConfirmLoginPOM;
import com.training.pom.LoginRegisterPOM;
import com.training.pom.LogoutPOM;
import com.training.pom.MyAccountPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RTTC002LoginTest {

private WebDriver driver;
private String baseUrl;
private String userName;
private String passWord;
private LoginRegisterPOM loginRegisterPOM;
private RetailHomePOM retailHomePOM;
private MyAccountPOM myAccountPOM;
private ConfirmLoginPOM confirmLoginPOM;
private LogoutPOM logoutPOM;
private static Properties properties;
private ScreenShot screenShot;
	
@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		 
	}
	
@BeforeMethod   //initializing 
public void setUp() throws Exception {
	        driver = DriverFactory.getDriver(DriverNames.CHROME);
			baseUrl = properties.getProperty("baseURL");
			userName= properties.getProperty("username");
			passWord=properties.getProperty("password");
			retailHomePOM = new RetailHomePOM(driver);
    	    loginRegisterPOM = new LoginRegisterPOM(driver);
    	    myAccountPOM = new MyAccountPOM(driver);
    	    confirmLoginPOM = new ConfirmLoginPOM(driver);
    	    logoutPOM = new LogoutPOM(driver);
    	    screenShot = new ScreenShot(driver); 
	 		driver.get(baseUrl); 	// open the browser
     		retailHomePOM.GotoLoginPage();
     		
		}
	
@AfterMethod
	
public void tearDown() throws Exception {
	
	 driver.quit();
	}
	

//This test case is to Login into application with provided user id and password
@Test 
	public void UserLoginTest()
	{
		loginRegisterPOM.userDetails(userName,passWord);  
		loginRegisterPOM.clickLoginBtn();
		myAccountPOM.validateConfirmationMsg();
		screenShot.captureScreenShot("MyAccountPage_RTTC_002");
		confirmLoginPOM.logout();
		
		}
		
}
