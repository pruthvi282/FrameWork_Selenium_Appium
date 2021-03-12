package generic;




import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.google.common.io.Files;
/**
 * 
 * @author Pruthvi
 *
 */

public class WebDriverUtilis {
	
	WebDriver driver;
	/**
	 * Wait until Element is Visible
	 * @param driver
	 * @param element
	 */
	public void waitForvisbilityElement(WebDriver driver, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver,Path_constants.elementclickablewait);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForPageToLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * Wait until Element is Clickable
	 * @param driver
	 * @param element
	 */
	public void waitForclickableElement(WebDriver driver, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver,Path_constants.elementclickablewait);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * Custom wait until elements get Clicks
	 * @param element
	 * @throws Throwable
	 */
	public void Custom_wait(WebElement element) throws Throwable{
		int count=0;
		while(count<20){
		try{
			element.click();
			break;
		}
		catch (Exception e) {
			Thread.sleep(500);
			count++;
		}
	  }
	}
	
	
//*************DropDown**********//
		/**
		 * Elements in dropdown gets selected by visibletext
		 * @param drop
		 * @param text
		 */
		public void dropdown(WebElement drop,String text){
			Select s=new Select(drop);
			s.selectByVisibleText(text);
		}
		/**
		 * Elements in dropdown gets selected by index
		 * @param drop
		 * @param index
		 */
		public void dropdown(WebElement drop,int index){
			Select s=new Select(drop);
			s.selectByIndex(index);
		}
		
		public int dropdown(WebElement drop){
			Select s=new Select(drop);
			List<WebElement> options = s.getOptions();
			int numb_options = options.size();
			return numb_options;
		}
		
//*********FRAMES***********//
		/**
		 * control goes to frame by passing index
		 * @param driver
		 * @param index
		 */
		public void frame(WebDriver driver,int index){
			driver.switchTo().frame(index);
		}
		/**
		 * control goes to frame by passing id
		 * @param driver
		 * @param id
		 */
		public void frame(WebDriver driver,String id){
			driver.switchTo().frame(id);
		}
		/**
		 * control goes to frame by passing frame address
		 * @param driver
		 * @param ele
		 */
		public void framebyaddress(WebDriver driver,WebElement ele){
			driver.switchTo().frame(ele);
		}
		/**
		 * switches to parent frame
		 * @param driver
		 */
		public void frame(WebDriver driver){
			driver.switchTo().defaultContent();
		}
		
//*******scroll********
		/**
		 * To scroll the webpage
		 * @param driver
		 * @param x
		 * @param y
		 */
		public void scroll(WebDriver driver,int x,int y){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
		}
//*******Action******//
		/**
		 * To move offset based on x & y
		 * @param driver
		 * @param x
		 * @param y
		 */
		public void action_gen(WebDriver driver,int x,int y){
			Actions act=new Actions(driver);
			act.moveByOffset(x, y).click().perform();
		}
		/**
		 * To Right click on a WebElement
		 * @param driver
		 */
		public void action_gen(WebDriver driver,WebElement ele){
			Actions act=new Actions(driver);
			act.contextClick(ele).perform();
		}
		/**
		 * To double click on a WebElement
		 * @param driver
		 * @param ele
		 */
		public void action_doubleclick(WebDriver driver,WebElement ele){
			Actions act=new Actions(driver);
			act.doubleClick(ele).perform();
		}
		/**
		 * To mouse hover on a WebElement
		 * @param driver
		 * @param ele1
		 */		
		public void action_Mousehover(WebDriver driver,WebElement ele1){
			Actions act=new Actions(driver);
			act.moveToElement(ele1).perform();
		}
		/**
		 * To switch from one window to another Window
		 * @param driver
		 * @param win
		 */
		public void Switch_to(WebDriver driver,String win){
		driver.switchTo().window(win);
		}
		
		/**
		 * Switching from one window to another window
		 * @param driver
		 * @param Title
		 */
		public void switch_to_window(WebDriver driver,String Title){
			Set<String> ids = driver.getWindowHandles();
			for(String win:ids){
				driver.switchTo().window(win);
				String title = driver.getTitle();
				if(title.contains(Title)){
					break;
				}
			}
		}	
		//calenderpopup
		public void CalenderPopups(WebDriver driver){
			
			
		}
		public void Take_Screen_Shot(String method ) throws Throwable{
			Java_utilities java=new Java_utilities();
			String d = java.DatewithTime();
			String date = d.replace(":", "_").replace(" ", "_");
			EventFiringWebDriver scrnshot=new EventFiringWebDriver(Baseclass.staticdriver);
			File src=scrnshot.getScreenshotAs(OutputType.FILE);
			File dst=new File("./ScreenShots/"+method+date+".PNG");
			Files.copy(src, dst);
		}

		
}

