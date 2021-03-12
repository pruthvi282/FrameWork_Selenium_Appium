package com.erp.SMrail.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebDriverUtilis;

public class Logout {
	//WebDriver driver;
	WebDriverUtilis web =new WebDriverUtilis();
	
	public Logout(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Signout;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signout;


	public void Signout(WebDriver driver) throws Throwable{
		web.Custom_wait(signout);
		web.action_Mousehover(driver, Signout);
		signout.click();
	}

	
}
