package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CategoriesPOM {
private WebDriver driver; 

	
public  CategoriesPOM(WebDriver driver) {
	     	this.driver = driver; 
			PageFactory.initElements(driver, this);
				
		} 

@FindBy(xpath="//h1[contains(text(),'Categories')]")
private WebElement categoryPage;

@FindBy(xpath="//*[@id=\'form-category\']/div/table/thead/tr/td[2]/a")
private WebElement categoryNameHeader;

@FindBy(xpath="//*[@id=\'form-category\']/div/table/thead/tr/td[3]/a")
private WebElement sortHeader;

@FindBy(xpath="//*[@id=\'form-category\']/div/table/thead/tr/td[4]")
private WebElement actionHeader;

@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
private WebElement addBtn;

@FindBy(xpath="//*[@id=\'content\']/div[2]/div[1]")
private WebElement successMsg;

@FindBy(xpath="//*[@id=\'header\']/ul/li[4]/a/span")
private WebElement logoutBtn;


//This method is to validate category page
public void validatecategoryPage()
{
  	String expectedCatergory ="Categories";
  	Assert.assertEquals(categoryPage.getText(), expectedCatergory);
  	
  	Assert.assertEquals(categoryNameHeader.getText(), "Category Name");
  	Assert.assertEquals(sortHeader.getText(), "Sort Order");
  	Assert.assertEquals(actionHeader.getText(), "Action");
}

//This method is to add category
public void clickAddCategory()
{
	addBtn.click();
}

// This method is to validate category added
public void validateCategoryAdded()
 {
	Assert.assertTrue(successMsg.getText().contains("Success"));
  }

//This method is to logout from admin URL
public void logoutAdmin()
{
	 logoutBtn.click();
	 
}
}