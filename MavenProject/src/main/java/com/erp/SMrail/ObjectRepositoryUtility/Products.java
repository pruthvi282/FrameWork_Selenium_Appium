package com.erp.SMrail.ObjectRepositoryUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.ExcelUtlities;
import generic.Path_constants;
import generic.WebDriverUtilis;

public class Products {
	WebDriver driver;
	
	WebDriverUtilis web=new WebDriverUtilis();

	public Products(WebDriver driver){
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement CreateProdButton;

	@FindBy(xpath="//input[@name='productname']")
	private WebElement ProdName;
	

	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement VendLookup;
	
	//ChildBrowser
	@FindBy(xpath="//a[@id='1']")
	private WebElement SelectVend;
	
	//parent Browser SaveButton
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//moreCurrencyLink
	@FindBy(xpath="//a[.='more currencies »']")
	private WebElement morecurrency;
	
	//productPricesTable
	@FindBy(xpath="//b[.='Product Prices']")
	private WebElement productpriceTitle;
	
	//StockInfoUsageUnitDopDown
	@FindBy(xpath="//select[@name='usageunit']")
	private WebElement UsageUnitDrop;
	
	//ProductImageUpload
	@FindBy(xpath="//input[@type='file']")
	private WebElement fileupload;
	
	//DeleteUploadedProductFile
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteuploaded;
	
	//Edit Product
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[4]/td[9]//a[.='edit']")
	private WebElement editproduct;
	
	//prodDetails
	@FindBy(xpath="//input[@id='productcode']")
	private WebElement PartNumber;
	
	@FindBy(xpath="//input[@name='sales_start_date']")
	private WebElement SalesStartDate ;
	
	@FindBy(xpath="//select[@name='productcategory']")
	private WebElement ProductCategoryDrop;
	
	@FindBy(xpath="//input[@name='sales_end_date']")
	private WebElement SalesEndDate; 
	
	@FindBy(xpath="//input[@title='Cancel [Alt+X]']")
	private WebElement cancelButton;
	
	@FindBy(xpath="//div[@class='calendar']/table/tbody/tr[@class='daysrow']/td[@class='day' and .='8']")
	private WebElement SelectDate;
	
	//
//********************WebElement Actions*********************************//	
	
	public WebElement getSelectDate() {
		return SelectDate;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getSalesEndDate() {
		return SalesEndDate;
	}

	public WebElement getProductCategoryDrop() {
		return ProductCategoryDrop;
	}

	public WebElement getSalesStartDate() {
		return SalesStartDate;
	}

	public WebElement getPartNumber() {
		return PartNumber;
	}

	//createproduct
	public void getCreateProductButton(){
		CreateProdButton.click();
	}
	
	//productname
	public  void getProductName(String Prod_Name){
		ProdName.sendKeys(Prod_Name);
	}

	public WebElement getCreateProdButton() {
		return CreateProdButton;
	}

	//vendorLookupButton
	public void getVendorLookupButton(){
		VendLookup.click();
	}

	public void getSelectVend(){
		SelectVend.click();
	}

	public void getSaveBtn(){
		SaveBtn.click();
	}

	public void getmorecurrency(){
		morecurrency.click();
	}

	public String getproductpriceTitle(){
	return productpriceTitle.getText();
	}
	
	//StockInfoUsageUnitDopDown
	public WebElement getUsageUnitDrop(){
		return UsageUnitDrop;
	}

	//fileUploadButton
	public void UploadButton(String File){
		fileupload.sendKeys(File);
	}

	//deleteuploaded
	public WebElement getdeleteuploaded(){
		return deleteuploaded;
	}

		//editproduct
	public void geteditproduct(){
		editproduct.click();
	}
}

