package login_generic;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import generic.FileUtility;
import generic.Path_constants;
import generic.WebDriverUtilis;

public class generic_Vtiger_login {
	public WebDriver driver;
	FileUtility file=new FileUtility();
	WebDriverUtilis web=new WebDriverUtilis();
	@BeforeMethod
	public void login() throws Throwable{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(file.property_data(Path_constants.property_path, "url"));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(file.property_data(Path_constants.property_path, "username"));
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(file.property_data(Path_constants.property_path, "password"));
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();		
	}
	/*@AfterMethod
	public void closeapp() throws InterruptedException{
	WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	web.waitForvisbilityElement(driver, logout);
	web.action_Mousehover(driver,logout);
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}
	*/
}
