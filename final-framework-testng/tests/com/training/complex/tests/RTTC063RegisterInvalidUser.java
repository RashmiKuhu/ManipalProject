package com.training.complex.tests;

import com.training.pom.RetailHomePOM;
import com.training.pom.AdminDashBoardPOM;
import com.training.pom.AdminLoginPOM;
import com.training.pom.ConfirmLoginPOM;
import com.training.pom.CustomerDetailsPOM;
import com.training.pom.ErrorRegisterUserPOM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginRegisterPOM;
import com.training.pom.RegisterUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC063RegisterInvalidUser {
			
	private WebDriver driver;
	private String baseUrl;
	private String adminUrl;
	private String adminId;
	private String adminPwd;
	private LoginRegisterPOM loginRegisterPOM;
	private RetailHomePOM retailHomePOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private RegisterUserPOM registeUserPOM;
    private ErrorRegisterUserPOM errorRegisterUserPOM;
			

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
				adminUrl= properties.getProperty("adminURL");
				adminId =  properties.getProperty("adminUsername");
		    	adminPwd = properties.getProperty("adminPassword");
				retailHomePOM = new RetailHomePOM(driver);
				loginRegisterPOM = new LoginRegisterPOM(driver);
				registeUserPOM = new RegisterUserPOM(driver);
				errorRegisterUserPOM= new ErrorRegisterUserPOM(driver);
				screenShot = new ScreenShot(driver); 
			   	driver.get(baseUrl); 	// open the browser
		        retailHomePOM.GotoLoginPage();     //Mouseover on My Account icon 
				loginRegisterPOM.clickRegisterBtn(); //click on the Register/Login button
				
			}
		 
			
			
 @AfterMethod
   public void cleanUp() throws Exception {
        driver.quit();
	    
		}



// This test case is to RegisterUser test register User with given below details.
@Test(dataProvider = "invalidUser", dataProviderClass = LoginDataProviders.class)
	public void RegisterUserTest(int rowNumber,String FirstName,String LastName,String eMail,String Telephone,String Address,String ExtraAddress,String City,String PostCode,String Country,String Region,String Password,String ConfirmPassword) throws Exception
			{
				registeUserPOM.populateUser(rowNumber,FirstName,LastName,eMail,Telephone,Address,ExtraAddress,City,PostCode,Country,Region,Password,ConfirmPassword);
				screenShot.captureScreenShot("AccountCreated_RTTC_063"+"_"+rowNumber);
				
			    
			    
			}
		
			
		



}
