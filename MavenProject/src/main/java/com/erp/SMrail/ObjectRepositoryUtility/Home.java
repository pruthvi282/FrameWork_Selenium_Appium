package com.erp.SMrail.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebDriverUtilis;

public class Home {
	WebDriver driver;
WebDriverUtilis Wlib=new WebDriverUtilis();
	public Home(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//a[.='Products'])[1]")
	private WebElement ProductLink;


	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement MoreImgBtn;
	
	@FindBy(xpath="//a[.='Vendors']")
	private WebElement Vendorslink;


	public WebElement getVendorslink() {
		return Vendorslink;
	}


	public WebElement getMoreImgBtn() {
		return MoreImgBtn;
	}
	
	public void clickOnprodlink(){
		ProductLink.click();
	}
}

