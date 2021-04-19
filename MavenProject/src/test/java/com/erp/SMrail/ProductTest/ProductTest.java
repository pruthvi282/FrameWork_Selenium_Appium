package com.erp.SMrail.ProductTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.erp.SMrail.ObjectRepositoryUtility.Home;
import com.erp.SMrail.ObjectRepositoryUtility.Login;
import com.erp.SMrail.ObjectRepositoryUtility.Logout;
import com.erp.SMrail.ObjectRepositoryUtility.Products;
import com.erp.SMrail.ObjectRepositoryUtility.Vendor;

import generic.Baseclass;
import generic.ExcelUtlities;
import generic.FileUtility;
import generic.Java_utilities;
import generic.Path_constants;
import generic.WebDriverUtilis;

@Listeners(generic.Listener_Implementation.class)
public class ProductTest extends Baseclass {
	FileUtility file = new FileUtility();
	WebDriverUtilis web = new WebDriverUtilis();
	ExcelUtlities ex = new ExcelUtlities();
	Java_utilities jav = new Java_utilities();

	@Test
	public void ProductTest1() throws Throwable {
		
		String excelPath = Path_constants.excel_path;
		String data=ex.getExcelData(excelPath, "ProdDetails", "TC_10", "Vendor");
		String VendorName = jav.randam_name(data, 1000);
		
		//precondition
		Home hm=new Home(driver);
		hm.getMoreImgBtn().click();
		hm.getVendorslink().click();
		
		Vendor vn=new Vendor(driver);
		vn.getCreateVendImg().click();
		vn.getVendorName().sendKeys(VendorName);
		vn.getSaveBtn().click();
			
		// Step1
		Home hom = new Home(driver);
		hom.clickOnprodlink();

		// Step2
		Products p = new Products(driver);
		p.getCreateProductButton();

		// step3
		String ProName = ex.excel(Path_constants.excel_path, "products", 0, 0);
		String product_Name = jav.randam_name(ProName, 1000);
		System.out.println(product_Name);
		p.getProductName(product_Name);
		System.out.println("************" + driver.getTitle());

		// step4
		p.getVendorLookupButton();
		
		// SwitchTo ChildWindow
		web.switch_to_window(driver, "Vendors");
		
		//vn.getSearchfield().sendKeys(VendorName);
		driver.findElement(By.xpath("//a[.='"+VendorName+"']")).click();
		//p.getSelectVend();

		// step5
		// SwitchTo ParentWindow
		web.switch_to_window(driver, "Products");
		// click on save
		p.getSaveBtn();
		
		//validation
		String expected = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		
		Assert.assertTrue(expected.contains(product_Name));
		System.out.println("validated");
	
	
	}
}
