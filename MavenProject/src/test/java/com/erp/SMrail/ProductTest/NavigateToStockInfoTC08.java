package com.erp.SMrail.ProductTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class NavigateToStockInfoTC08 extends Baseclass {

	FileUtility file = new FileUtility();
	WebDriverUtilis web = new WebDriverUtilis();
	ExcelUtlities ex = new ExcelUtlities();
	Java_utilities jav = new Java_utilities();

	@Test
	public void NavigateToStockInfo() throws Throwable {

		int ExpectedDropDownValues = 16;
		// Step2
		Home hom = new Home(driver);
		hom.clickOnprodlink();

		// Step3
		Products p = new Products(driver);
		p.getCreateProductButton();

		// step4
		web.scroll(driver, 0, 500);
		WebElement dropdown = p.getUsageUnitDrop();
		dropdown.click();
		int ActualDropDownValues = web.dropdown(dropdown);

		// validation
		System.out.println("**********");
		Assert.assertEquals(ActualDropDownValues, ExpectedDropDownValues);
		System.out.println("Usuage Unit Type Is Displayed");
		System.out.println("**********");

		web.scroll(driver, 0, -500);

	}

}
