package com.erp.SMrail.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebDriverUtilis;

public class Vendor {

	WebDriverUtilis Wlib=new WebDriverUtilis();
	WebDriver driver;
	
	public Vendor(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@title='Create Vendor...']")
	private WebElement createVendImg;
	
	@FindBy(xpath="//input[@name='vendorname']")
	private WebElement VendorName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchfield;
	
	
	public WebElement getSearchfield() {
		return searchfield;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getVendorName() {
		return VendorName;
	}

	public WebElement getCreateVendImg() {
		return createVendImg;
	}

}
