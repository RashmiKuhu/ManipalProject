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
import com.training.pom.ForgotPasswordPOM;
import com.training.pom.LoginRegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC003ForgotPasswordTest {

private WebDriver driver;
private String baseUrl;
private RetailHomePOM retailHomePOM;
private LoginRegisterPOM loginRegisterPOM;
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
        forgotPasswordPOM = new ForgotPasswordPOM(driver);
	    screenShot = new ScreenShot(driver); 
 		driver.get(baseUrl); 	// open the browser
   		retailHomePOM.GotoLoginPage();
     			
	}

@AfterMethod
	
 public void tearDown() throws Exception {

driver.quit();
}
	

//This test case is to validate Forgot Password functionality
@Test
	public void ForgotPasswordTest()
		{
		loginRegisterPOM.userDetails("Reshu123@gmail.com","ertyuu");
		loginRegisterPOM.clickLoginBtn();
		loginRegisterPOM.validateWarningInvalidPassword("Warning: No match for E-Mail Address and/or Password."); 
		screenShot.captureScreenShot("WarningMsgRTTC_003");
		loginRegisterPOM.clickForgotPasswordLnk();         //clicking on the forgot password 
		forgotPasswordPOM.PopulateEmail("Reshu123@gmail.com");
		forgotPasswordPOM.clickContinueBtn();
		loginRegisterPOM.validateConfirmationMsg();
		screenShot.captureScreenShot("ConfirmationMsgRTTC_003");
	}
}





