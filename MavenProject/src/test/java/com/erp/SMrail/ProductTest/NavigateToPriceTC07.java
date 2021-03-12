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
public class NavigateToPriceTC07 extends Baseclass{
	
	FileUtility file=new FileUtility();
	WebDriverUtilis web=new WebDriverUtilis();
	ExcelUtlities ex=new ExcelUtlities();
	Java_utilities jav=new Java_utilities();
	
	@Test
	public void NavigateToPrice() throws Throwable{
	//Step1
	Home hom=new Home(driver);
	hom.clickOnprodlink();
	
	//Step2
	Products p=new Products(driver);
	p.getCreateProductButton();
	
	//Step3
	web.scroll(driver, 0, 200);
	p.getmorecurrency();
	
	//validation
	String expected="Product Prices";
	System.out.println("**********");
	 String Actual = p.getproductpriceTitle();
	 
	 //validation
	 Assert.assertEquals(Actual, expected);
	 System.out.println("product Price page is Displayed");
	 System.out.println("**********");

	 web.scroll(driver, 0, -200);

	 
}
}
