package com.Vtiger_product_testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.ExcelUtlities;
import generic.Java_utilities;
import generic.Path_constants;
import generic.WebDriverUtilis;
import generic.generic_Vtiger_login;

public class TC_02 extends generic_Vtiger_login{
	String Expected_aler="Product Name cannot be empty";
	ExcelUtlities ex=new ExcelUtlities();
	Java_utilities j=new Java_utilities();
	
	
	public void waitForElement(WebDriver driver, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	@Test
	public void create_product_without_mandatary() throws Throwable{
		driver.findElement(By.xpath("(//a[.='Products'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		Thread.sleep(3000);	
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Alert al = driver.switchTo().alert();
		String Actual_alert = al.getText();
		al.accept();
		Assert.assertEquals(Actual_alert, Expected_aler);
		System.out.println("========================");
		System.out.println("Alert pop-Up should be displayed with below error msg" + "+Actual_alert+");
		System.out.println("========================");
} 
}
