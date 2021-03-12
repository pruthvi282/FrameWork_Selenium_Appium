package generic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

 public class Listener_Implementation implements ITestListener{

	 ExtentReports report;
	 ExtentTest test;
	  public void onFinish(ITestContext arg0) {					
		 
  		report.flush();
	    }		

	   		
	    public void onStart(ITestContext arg0) {		
	    	ExtentSparkReporter htmlreporter=new ExtentSparkReporter("./extentreport.html");
	    	htmlreporter.config().setTheme(Theme.DARK);
	    	htmlreporter.config().setDocumentTitle("Test application");
	    	 report=new ExtentReports();
	    	report.attachReporter(htmlreporter);
	    	report.setSystemInfo("Platform", "windows");
	    	report.setSystemInfo("Os", "Windows");
	    	report.setSystemInfo("enviornment", "testing enviornment");
	    	report.setSystemInfo("reporter", "pruthvi");
	        				
	        		
	    }		

			
	    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
	        				
	        		
	    }		

	  		
	    public void onTestFailure(ITestResult result) {	
			WebDriverUtilis web=new WebDriverUtilis();
			Java_utilities java=new Java_utilities();
			String date = java.DatewithTime();
			try {
				web.Take_Screen_Shot( result.getMethod().getMethodName());
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		

	   		
	    public void onTestSkipped(ITestResult result) {					
	        				test.log(Status.SKIP, result.getMethod().getMethodName());
	        				test.log(Status.SKIP, result.getThrowable());
	        		
	    }		

	   	
	    public void onTestStart(ITestResult result) {					
	       				
	        		 test = report.createTest(result.getMethod().getMethodName());
	    }		

	   		
	    public void onTestSuccess(ITestResult result) {					
	        		test.log(Status.PASS, result.getMethod().getMethodName()+"is passed");	
	        		
	    }	 
	 
	
}
