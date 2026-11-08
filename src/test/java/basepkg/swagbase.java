package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import swagpagepkg.swaghomepage;
import swagpagepkg.swagloginpage;

public class swagbase {
	
	public static WebDriver driver;
   public static swagloginpage loginobj;
   public static swaghomepage homeobj;

	
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	@BeforeTest
	public void browsersetup()
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/myreport1.html");
		
		reporter.config().setDocumentTitle("Automationreport");
		reporter.config().setReportName("functional test");
		reporter.config().setTheme(Theme.DARK);

	    extent = new ExtentReports();
		extent.attachReporter(reporter);

		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("OS", "windows10");
		extent.setSystemInfo("Tester Name", "abc");
		extent.setSystemInfo("Browser Name", "chrome");
		
		
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}
	
	
@BeforeMethod
	
	public void objectmethod()
	{
		loginobj = new swagloginpage(driver);
		
		homeobj = new swaghomepage(driver);
		
	}
	
	
	@AfterMethod
	public void aftmthd(ITestResult result) throws Exception {

	    if (result.getStatus() == ITestResult.FAILURE) {

	        test.log(Status.FAIL, "test case failed is " + result.getName());
	        test.log(Status.FAIL, "test case failed is " + result.getThrowable());

	    }

	    else if (result.getStatus() == ITestResult.SUCCESS) {

	        test.pass("Test Passed: " + result.getName());

	    }

	    else if (result.getStatus() == ITestResult.SKIP) {

	        test.skip("Test Skipped: " + result.getName());

	    }

	}

	@AfterTest
	public void endReport() {

	    extent.flush();
	    driver.quit();

	}

}
