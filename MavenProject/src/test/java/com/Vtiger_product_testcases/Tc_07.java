package com.Vtiger_product_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.WebDriverUtilis;
import generic.generic_Vtiger_login;

public class Tc_07 extends generic_Vtiger_login {
	WebDriverUtilis web=new WebDriverUtilis();
@Test
public void more_currencies() throws Throwable{
	String Expected_res="Product Prices";
	driver.findElement(By.xpath("(//a[.='Products'])[1]")).click();
	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	web.scroll(driver, 200, 200);
	driver.findElement(By.xpath("//a[.='more currencies »']")).click();
	String Actualres = driver.findElement(By.xpath("//b[.='Product Prices']")).getText();
	web.scroll(driver, -200, -200);
	
	//validation
	
	Assert.assertEquals(Actualres, Expected_res);
	System.out.println("===================");
	System.out.println("validated");
	System.out.println("===================");
	
	
	//logout
	
	 WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 web.action_Mousehover(driver,logout);
	 driver.findElement(By.xpath("//a[.='Sign Out']")).click();

	}
}
