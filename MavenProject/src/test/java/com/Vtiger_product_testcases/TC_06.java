package com.Vtiger_product_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.FileUtility;
import generic.Path_constants;
import generic.WebDriverUtilis;
import generic.generic_Vtiger_login;

public class TC_06 extends generic_Vtiger_login {
	WebDriverUtilis web=new WebDriverUtilis();
	FileUtility file=new FileUtility();
	@Test
	public void tc06() throws Throwable{
		driver.findElement(By.xpath("(//a[.='Products'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

		//productname
		String pro_name = file.property_data(Path_constants.property_path, "product");
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(pro_name);
		
		//select_vendor(+)
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		 web.switch_to_window(driver, "Vendors");
		driver.findElement(By.xpath("//a[@id='1']")).click();
		
		//switch to parent
		 web.switch_to_window(driver, "Products");
		 driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		/*WebElement more = driver.findElement(By.xpath("//a[.='More']"));
		web.action_Mousehover(driver, more);
		 driver.findElement(By.xpath("//a[.='Campaigns']")).click();
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		String ven_name = file.property_data(Path_constants.property_path, "vendor");
		 driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(ven_name);
		 driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		 */
		
		
		
	}

}
