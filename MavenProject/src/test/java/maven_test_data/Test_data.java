package maven_test_data;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Test_data {
	@Test
	public void test(){
		WebDriver d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("http://localhost:8888/index.php?module=Home&action=index");
		d.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		 WebElement pwd = d.findElement(By.xpath("//input[@name='user_password']"));
		d.findElement(By.xpath("//input[@id='submitButton']")).click();		
	}

}
