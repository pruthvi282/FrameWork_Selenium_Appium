package com.erp.SMrail.ProductTest;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.erp.SMrail.ObjectRepositoryUtility.Home;
import com.erp.SMrail.ObjectRepositoryUtility.Products;

import generic.Baseclass;
import generic.ExcelUtlities;
import generic.FileUtility;
import generic.Java_utilities;
import generic.Path_constants;
import generic.WebDriverUtilis;

//@Listeners(generic.Listener_Implementation.class)
public class CreatProdWithAllDetails extends Baseclass {
	
	FileUtility file = new FileUtility();
	WebDriverUtilis web = new WebDriverUtilis();
	ExcelUtlities ex = new ExcelUtlities();
	Java_utilities jav = new Java_utilities();
	
	ExcelUtlities Elib=new ExcelUtlities();
	
	@Test
	public void CreatProdWithAllDetails() throws Throwable{
		String excelpath = Path_constants.excel_path;
		String sheetName="ProdDetails";
		String expTestID="TC_10";
		String expColHEader="ProdName";
		String Prod_Name=Elib.getExcelData(excelpath, sheetName, expTestID, expColHEader);
		String SalesSatrtDate=Elib.getExcelData(excelpath, sheetName, expTestID, "Sales Start Date");
		String PartNumber=Elib.getExcelData(excelpath, sheetName, expTestID, "Part Number");
		String SalesEndDate=Elib.getExcelData(excelpath, sheetName, expTestID, "Sales End Date");
		
		// Step1
				Home hom = new Home(driver);
				hom.clickOnprodlink();

				// Step2
				Products p = new Products(driver);
				p.getCreateProdButton();
				
				//step3 CreateProdWithAllDetails
				p.getProductName(Prod_Name);
				p.getSalesStartDate().sendKeys(SalesSatrtDate);
				p.getSalesEndDate().sendKeys(SalesEndDate);
				p.getPartNumber().sendKeys(PartNumber);
				
				//step4 cancel
				p.getCancelButton().click();
				
				//validation
				String Expected=null;
				String Actual = p.getSalesEndDate().getAttribute("value");
				Assert.assertEquals(Actual, Expected);
	}
}
