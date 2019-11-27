package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterUserPOM {
private WebDriver driver; 
	
	public RegisterUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="input-firstname") 
	private WebElement firstName; 
	
	@FindBy(id="input-lastname") 
	private WebElement lastName; 
	
	@FindBy(id="input-email") 
	private WebElement eMail; 
	
	@FindBy(id="input-telephone") 
	private WebElement telephone; 
	
	@FindBy(id="input-address-1") 
	private WebElement addressOne; 
	
	@FindBy(id="input-address-2") 
	private WebElement addressTwo; 

	@FindBy(id="input-city") 
	private WebElement city; 

	@FindBy(id="input-postcode") 
	private WebElement poctCode;

	@FindBy(id="input-country") 
	private WebElement country;
  
	@FindBy(id="input-zone") 
	private WebElement state;
  
	@FindBy(id="input-password") 
	private WebElement password;
	
	@FindBy(id="input-confirm") 
	private WebElement passwordConfirm;
	
	@FindBy(xpath="//label[contains(text(),'Yes')]")  // change below with contains 
	private WebElement subscribe;
	
	@FindBy(xpath="//label[contains(text(),'No')]")
	private WebElement subscribeOne;
	
	@FindBy(xpath="//label[@class='checkbox']") 
	private WebElement privacy;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement continue_Btn;
	
	
	public void populateUser(String firstName,String lastName,String eMail,String telephone,String addressOne,String addressTwo,String city,String poctCode,String country,String state) throws Exception
	{
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		
		this.eMail.clear();
		this.eMail.sendKeys(eMail);
		
		this.telephone.clear();
		this.telephone.click();
		this.telephone.sendKeys(telephone);
		
		this.addressOne.clear();
		this.addressOne.sendKeys(addressOne);
		
		this.addressTwo.clear();
		this.addressTwo.sendKeys(addressTwo);
	    
		this.city.clear();
		this.city.sendKeys(city);
	  
		this.poctCode.clear();
		this.poctCode.sendKeys(poctCode);
		
		Select contryDropdown = new Select(this.country);
		contryDropdown.selectByVisibleText(country);
		
		Select stateDropdown = new Select(this.state);
		stateDropdown.selectByVisibleText(state);
	   
		this.password.clear();
		this.password.sendKeys("Test123");
		
		this.passwordConfirm.clear();
		this.passwordConfirm.sendKeys("Test123");
		
		//		this.subscribe.isEnabled();
		this.subscribe.click();
		this.subscribeOne.click();
		//this.subscribe.isSelected();
		
		this.privacy.isEnabled();
		if (this.privacy.isSelected())
		{
			this.continue_Btn.click(); 
		}
		else {
			
		this.privacy.click();
		}
		
		//this.privacy.isEnabled();
		//this.privacy.click();
		//this.privacy.isSelected();
		
		this.continue_Btn.click();
		
	}
	

	
	
	
	
	

}
