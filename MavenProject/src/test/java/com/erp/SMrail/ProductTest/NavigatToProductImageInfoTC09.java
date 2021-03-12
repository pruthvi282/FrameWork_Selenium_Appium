package com.erp.SMrail.ProductTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.erp.SMrail.ObjectRepositoryUtility.Home;
import com.erp.SMrail.ObjectRepositoryUtility.Login;
import com.erp.SMrail.ObjectRepositoryUtility.Logout;
import com.erp.SMrail.ObjectRepositoryUtility.Products;

import generic.Baseclass;
import generic.ExcelUtlities;
import generic.FileUtility;
import generic.Java_utilities;
import generic.Path_constants;
import generic.WebDriverUtilis;

@Listeners(generic.Listener_Implementation.class)
public class NavigatToProductImageInfoTC09 extends Baseclass {

	FileUtility file = new FileUtility();
	WebDriverUtilis web = new WebDriverUtilis();
	ExcelUtlities ex = new ExcelUtlities();
	Java_utilities jav = new Java_utilities();

	@Test
	public void NavigatToProductImageInfo() throws Throwable {
		int ExpectedDropDownValues = 16;

		// Step1
		Home hom = new Home(driver);
		hom.clickOnprodlink();

		// Step2
		Products p = new Products(driver);
		p.getCreateProdButton();

		// step3 UploadFile&Delete
		web.scroll(driver, 0, 500);
		p.UploadButton("C:\\Users\\Admin\\Desktop\\notes\\2.jpeg");
		p.getdeleteuploaded().click();

		
		
		Assert.assertFalse( p.getdeleteuploaded().isDisplayed());
		System.out.println("validated");

		 web.scroll(driver, 0, -500);
	
	}

}
