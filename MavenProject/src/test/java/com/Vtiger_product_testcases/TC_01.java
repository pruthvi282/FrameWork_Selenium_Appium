package com.Vtiger_product_testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.ExcelUtlities;
import generic.FileUtility;
import generic.Java_utilities;
import generic.Path_constants;
import generic.WebDriverUtilis;
import generic.generic_Vtiger_login;

public class TC_01 extends  generic_Vtiger_login {
	ExcelUtlities ex=new ExcelUtlities();
	Java_utilities j=new Java_utilities();
	WebDriverUtilis web=new WebDriverUtilis();
	@Test
	public void create_product() throws Throwable{
		driver.findElement(By.xpath("(//a[.='Products'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		driver.findElement(By.xpath("(//a[.='Products'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		String prod = ex.excel(Path_constants.excel_path, "products", 0, 0);
		String product = j.randam_name(prod, 1000);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(product);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(product);
		driver.navigate().refresh();
		//driver.findElement(By.xpath("//table[@class='hdrTabBg']/tbody/tr[1]/td[1]")).click();
		driver.findElement(By.xpath("//table[@class='hdrTabBg']/tbody/tr[1]/td[2]//a[.='Products']")).click();
		WebElement dropele = driver.findElement(By.xpath("//select[@id='bas_searchfield']"));
		web.dropdown(dropele, "Product Name");
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		
		
	}
	
	
}
