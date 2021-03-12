package com.Vtiger_product_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.WebDriverUtilis;
import generic.generic_Vtiger_login;

public class TC_08 extends generic_Vtiger_login {
	WebDriverUtilis web=new WebDriverUtilis();
	@Test
	public void Usage_unit() throws Throwable{
		int Expected=16;
		driver.findElement(By.xpath("(//a[.='Products'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		web.scroll(driver, 500, 500);
		driver.findElement(By.xpath("//a[.='more currencies »']")).click();
		
		//usage_dropdown
		WebElement usage_drop = driver.findElement(By.xpath("//select[@name='usageunit']"));
		usage_drop.click();
		int actual = web.dropdown(usage_drop);
		web.scroll(driver, -500, -500);
		
		//validation
		System.out.println("************************");
		Assert.assertEquals(actual, Expected);
		System.out.println("validated");
		System.out.println("************************");
		
		//logout
		
		 WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 web.action_Mousehover(driver,logout);
		 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		 
		 
	
	}
}