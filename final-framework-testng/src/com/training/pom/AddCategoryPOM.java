package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCategoryPOM {
private WebDriver driver; 

	
public  AddCategoryPOM(WebDriver driver) {
	     	this.driver = driver; 
			PageFactory.initElements(driver, this);
				
		} 

@FindBy(xpath="//h3[@class='panel-title']")
private WebElement categoryPageTitle;

@FindBy(xpath="//input[@id='input-name1']")
private WebElement CategoryName;

@FindBy(xpath="//div[@class='note-editable panel-body']")
private WebElement categoryDesc;

@FindBy(id="input-meta-title1")
private WebElement metaTag;

@FindBy(xpath="//textarea[@id='input-meta-description1']")
private WebElement metaTagDesc;

@FindBy(xpath="//button[@class='btn btn-primary']")
private WebElement saveBtn;


public void validatePageTitle()
{
  String expectedTitle="Add Category";
  Assert.assertEquals(categoryPageTitle.getText(), expectedTitle);
  
}

public void addCategoryDetails(String name,String categoryDesc,String metaTag,String metaTagDesc)
{ 
	
   this.CategoryName.clear();
   this.CategoryName.sendKeys(name);
   
   this.categoryDesc.click();
   this.categoryDesc.sendKeys(categoryDesc);
   
   this.metaTag.clear();
   this.metaTag.sendKeys(metaTag);
   
   this.metaTagDesc.clear();
   this.metaTagDesc.sendKeys(metaTagDesc);
 
   saveBtn.click();
   
   
}






}