package com.erp.SMrail.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	public Login(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='user_name']")
	private WebElement Username;

	@FindBy(xpath="//input[@name='user_password']")
	private WebElement Password;
	
	@FindBy(xpath="//input[@id='submitButton']")
	private WebElement login_buttton;
	
	public void loginToApp(String UsrName,String Pass){
		Username.sendKeys(UsrName);
		Password.sendKeys(Pass);
		login_buttton.click();
	}
	
	public void loginToApp(){
		Username.sendKeys("admin");
		Password.sendKeys("admin");
		login_buttton.click();
	}
	
}
