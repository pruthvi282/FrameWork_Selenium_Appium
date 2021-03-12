package generic;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

	public  static void main(String[] args){
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php?module=Home&action=index");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		String win="parent";
		Set<String> set = driver.getWindowHandles();
		Map<String, String> map=new HashMap<String, String>();
		Iterator<String> itr = set.iterator();
		String parent = itr.next();
		String child=itr.next();
		map.put("parent", parent);
		map.put("child", child);
		driver.switchTo().window(map.get(win));
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys("asddsa");
		
		
		
	}

}
