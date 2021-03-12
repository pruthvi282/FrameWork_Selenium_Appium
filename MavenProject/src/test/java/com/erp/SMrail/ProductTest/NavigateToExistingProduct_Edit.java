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

import generic.Baseclass;
import generic.ExcelUtlities;
import generic.FileUtility;
import generic.Java_utilities;
import generic.Path_constants;
import generic.WebDriverUtilis;

@Listeners(generic.Listener_Implementation.class)
public class NavigateToExistingProduct_Edit extends Baseclass {

	FileUtility file = new FileUtility();
	WebDriverUtilis web = new WebDriverUtilis();
	ExcelUtlities ex = new ExcelUtlities();
	Java_utilities jav = new Java_utilities();

	@Test(groups="regression")
	public void NavigateToExistingProduct_Edit() throws Throwable {
		
		// Step1
		Home hom = new Home(driver);
		hom.clickOnprodlink();

		// Step2
		Products p = new Products(driver);
		p.geteditproduct();

		
		// validation
		String Expected_result="[ PRO10 ] product82 - Editing Product Information";
		String Actual_result = driver.findElement(By.xpath("//span[contains(text(),'Product')]")).getText();
		System.out.println(Actual_result);
		System.out.println("**************************");
		
		//validation
		Assert.assertEquals(Actual_result, Expected_result);
		System.out.println("**************");
		System.out.println(" product page should be display ");
		System.out.println("**************");
		
	}

}
