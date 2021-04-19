package com.remoteexecution;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteExecution {
	
	@Test
	
	public void executionInst() throws Throwable{
		URL url=new URL("http://localhost:4444/wd/hub");
		
		DesiredCapabilities cap= DesiredCapabilities.firefox();
		/*cap.setBrowserName("firefox");*/
		RemoteWebDriver driver=new RemoteWebDriver(url, cap);
		System.out.println();
		driver.get("https://webmail.testyantra.in/");
		
	
	
	}

}
