package com.training.complex.tests;

import com.training.pom.RetailHomePOM;
import com.training.pom.AddCategoryPOM;
import com.training.pom.AdminDashBoardPOM;
import com.training.pom.AdminLoginPOM;
import com.training.pom.CategoriesPOM;
import com.training.pom.ConfirmLoginPOM;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginRegisterPOM;
import com.training.pom.RegisterUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC064AdminAddCategory {
		
private WebDriver driver;
private String adminUrl;
private String adminId;
private String adminPwd;
private AdminLoginPOM adminLoginPOM;
private AdminDashBoardPOM adminDashBoardPOM;
private CategoriesPOM categoriesPOM;
private AddCategoryPOM addCategoryPOM;
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
	    	adminUrl = properties.getProperty("adminURL");
	    	adminId =  properties.getProperty("adminUsername");
	    	adminPwd = properties.getProperty("adminPassword");
	    	adminLoginPOM = new AdminLoginPOM(driver);
	    	adminDashBoardPOM = new AdminDashBoardPOM(driver);
	    	categoriesPOM = new CategoriesPOM(driver);
	    	addCategoryPOM = new AddCategoryPOM(driver);
			screenShot = new ScreenShot(driver); 
		   	driver.get(adminUrl); 	// open the browser
	       	
		   	adminLoginPOM.loginToAdmin(adminId, adminPwd);
		   			   	
		}
	 

@AfterMethod
  public void tearDown() throws Exception {
    driver.quit();
	   
}

@Test(dataProvider = "addCategory", dataProviderClass = LoginDataProviders.class)
public void addCategory(String CategoryName,String Description,String MetaTagTitle,String MetaTagDescription) throws Exception
{ 
	adminDashBoardPOM.dashBoardVisible();
	adminDashBoardPOM.navigateToCategories();
	categoriesPOM.validatecategoryPage();
	categoriesPOM.clickAddCategory();
	addCategoryPOM.validatePageTitle();
	addCategoryPOM.addCategoryDetails(CategoryName, Description, MetaTagTitle, MetaTagDescription);
	categoriesPOM.validateCategoryAdded();
	categoriesPOM.logoutAdmin();
	adminLoginPOM.validateLoginPage();
}


}
	

