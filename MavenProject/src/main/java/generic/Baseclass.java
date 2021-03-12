package generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.erp.SMrail.ObjectRepositoryUtility.Login;
import com.erp.SMrail.ObjectRepositoryUtility.Logout;
import com.mysql.cj.jdbc.Driver;
/**
 * 
 * @author Pruthvi
 *
 */

public class Baseclass {
	public WebDriver driver;
	FileUtility fLib=new FileUtility();
	WebDriverUtilis wlib=new WebDriverUtilis();
	JDBCutility dlib=new JDBCutility();
	public static  WebDriver staticdriver;
	
	@BeforeSuite
	/**
	 * connecting to database
	 * @throws Throwable
	 */
	
	public void connectToDB() throws Throwable {
		dlib.connectToDB();

	}
	
	@BeforeClass
	public void configBeforeClass() throws Throwable {
		/* launch the Browser*/
		/*read Common Data*/
		String URL = fLib.property_data(Path_constants.property_path, "url");

		String BROWSER = fLib.property_data(Path_constants.property_path, "Browser");
		
		 if(BROWSER.equals("firefox")) {
		    driver = new FirefoxDriver();
		 }else if(BROWSER.equals("chrome")) {
			 driver = new ChromeDriver();
		 }else if(BROWSER.equals("ie")) {
			 driver = new InternetExplorerDriver();
		 }else {
			 driver = new ChromeDriver();
		 }
		staticdriver=driver;
		 wlib.waitForPageToLoad(driver);
		 driver.get(URL);
	}
	
	//@Parameters("BROWSER")
	//@BeforeClass
		public void configBeforeClasscomp(String browser) throws Throwable {
			/* launch the Browser*/
			/*read Common Data*/
			String URL = fLib.property_data(Path_constants.property_path, "url");
			
			 if(browser.equals("firefox")) {
			    driver = new FirefoxDriver();
			 }else if(browser.equals("chrome")) {
				 driver = new ChromeDriver();
			 }else if(browser.equals("ie")) {
				 driver = new InternetExplorerDriver();
			 }else {
				 driver = new ChromeDriver();
			 }
			
			 wlib.waitForPageToLoad(driver);
			 driver.get(URL);
		}
	
	/**
	 * login to application
	 * @throws Throwable
	 */
	@BeforeMethod
	public void configBeforeMtd() throws Throwable {
		/*step-1 : login to Application*/
		String USERNAME = fLib.property_data(Path_constants.property_path, "username");
		String PASSWORD = fLib.property_data(Path_constants.property_path, "password");
		Login lp=new Login(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	}
	
	/**
	 * Logout From the Application
	 * @throws Throwable
	 */
	@AfterMethod
	public void configAfterMethod() throws Throwable {
		Logout logout=new Logout(driver);
		 logout.Signout(driver);
    }
	
	/**
	 * close the Browser
	 */

	@AfterClass
	public void configAfterClass() {
		driver.close();
	}
	
	@AfterSuite
	/**
	 * closing database connection
	 * @throws SQLException
	 */
	public void closeDb() throws SQLException {
		dlib.closeDb();
	}
	
}