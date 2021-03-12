package vtiger;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Java_utilities;



public class Vtiger_testcase2 {
@Test
public void windowpopup() throws InterruptedException, Throwable, InvalidFormatException, IOException{
	System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://localhost:8888/index.php?module=Home&action=index");
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	
	Exceldata ex=new Exceldata();
	String data1 = ex.excel("Sheet1", 0, 0);
	
	Java_utilities ran=new Java_utilities();
	String data2 = ran.randam_name(data1,1000);
	System.out.println(data2);
	
	driver.findElement(By.xpath("//a[.='Organizations']")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(data2);
	Thread.sleep(3000);
	String par = driver.getWindowHandle();
	Set<String> childs = driver.getWindowHandles();
	childs.remove(par);
	for(String s:childs){
		driver.switchTo().window(s);
		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys("bajaj");
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='1']")).click();
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	driver.switchTo().window(par);
	driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
	
	//validation
	Thread.sleep(10000);
	System.out.println("waited");
	//driver.findElement(By.xpath("//img[@src='themes/softed/images/Home.PNG']")).click();
	driver.findElement(By.xpath("//a[.='Organizations']")).click();
	
	List<WebElement> res = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']"));
	System.out.println(data2);
	for(WebElement wb:res){
		String s = wb.getText();
		if(s.equals(data2)){
			System.out.println("validated");
		}
	}
	/*Assert.assertTrue(res.contains(data2));
	System.out.println("validated");*/
}
}