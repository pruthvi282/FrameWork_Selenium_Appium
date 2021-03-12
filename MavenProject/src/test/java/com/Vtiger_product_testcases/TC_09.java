package com.Vtiger_product_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.WebDriverUtilis;
import generic.generic_Vtiger_login;

public class TC_09 extends generic_Vtiger_login {
	WebDriverUtilis web=new WebDriverUtilis();
@Test
public void fileupload() {
	String Expected="C:\fakepath\7.jpeg";
	driver.findElement(By.xpath("(//a[.='Products'])[1]")).click();
	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	web.scroll(driver, 500, 500);
	
	//fileupload
	driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Admin\\Desktop\\notes\\1.jpeg");
	driver.findElement(By.xpath("//input[@value='Delete']")).click();
	
	//validation
	
	// boolean actual = driver.findElement(By.xpath("//div[.='C:\fakepath\7.jpeg']")).isDisplayed();
		System.out.println("validated");
		Assert.assertFalse(driver.findElement(By.xpath("//div[.='C:\fakepath\7.jpeg']")).isDisplayed());
		System.out.println("validated");
	
	web.scroll(driver, -500, -500);
	
	//logout
	
	 WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 web.action_Mousehover(driver,logout);
	 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	
}
}
