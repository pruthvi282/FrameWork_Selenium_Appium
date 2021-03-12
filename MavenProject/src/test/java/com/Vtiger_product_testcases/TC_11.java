package com.Vtiger_product_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.WebDriverUtilis;
import generic.generic_Vtiger_login;


public class TC_11 extends generic_Vtiger_login {
WebDriverUtilis web=new WebDriverUtilis();
	@Test
	public void edit_product(){
		String Expected_result="[ PRO10 ] product82 - Editing Product Information";
		driver.findElement(By.xpath("(//a[.='Products'])[1]")).click();
		
		//select prod & edit
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[4]/td[9]//a[.='edit']")).click();
		
		//validation
		String Actual_result = driver.findElement(By.xpath("//span[contains(text(),'Product')]")).getText();
	System.out.println(Actual_result);
		Assert.assertEquals(Actual_result, Expected_result);
	System.out.println("**************");
	System.out.println("validated");
	System.out.println("**************");
	
	
	//logout
	
	 WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 web.action_Mousehover(driver,logout);
	 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}

}
