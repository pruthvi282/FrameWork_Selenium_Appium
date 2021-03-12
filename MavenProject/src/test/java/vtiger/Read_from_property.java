package vtiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import generic.FileUtility;
import generic.Java_utilities;
import generic.Path_constants;

public class Read_from_property {
	@Test
	public void property() throws Throwable{
		WebDriver d=new FirefoxDriver();
		d.get("http://localhost:8888/index.php?action=index&module=Home");
		FileUtility gen=new FileUtility();
		String log = gen.property_data(Path_constants.property_path, "username");
		String pass = gen.property_data(Path_constants.property_path, "password");
		d.findElement(By.xpath("//input[@name='user_name']")).sendKeys(log);
		d.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pass);
		d.findElement(By.xpath("//input[@id='submitButton']")).click();
	}

}
