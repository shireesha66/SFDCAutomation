package tests;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ReportManager;

	public class BaseTest {
		
		//static variables are not instance variables of class
		public static ExtentReports report;
        public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
		public static ThreadLocal<ExtentTest> threadLocalTest = new ThreadLocal<ExtentTest>();
		public static Logger logger = LogManager.getLogger("BaseTest");
		
		public static void setDriver(String browserName, boolean headless) {
			WebDriver driver = BaseTest.getBrowserDriver(browserName, headless);
			logger.debug("Basetest:setDriver: browser object set for" + browserName );
			threadLocalDriver.set(driver);
			}
		
		public static  WebDriver getBrowser() {
			return threadLocalDriver.get();
		}
		@Parameters("bName")
		@BeforeMethod
		public void setupBrowser(@Optional("chrome")String browserName,Method name) {
			
			BaseTest.setDriver(browserName, false);
			logger.debug("Basetest:setupBrowse: browser object is settingup..");
			ExtentTest test = report.createTest(name.getName());
			logger.debug("Basetest:setupBrowser: test object is set for function" + name.getName() );
			threadLocalTest.set(test);
		}
		
		@AfterMethod
		public void closeBrowser() {
			logger.debug("Basetest:closeBrowser: quitting browser...." );
			threadLocalDriver.get().quit();
			threadLocalDriver.remove();
			logger.debug("Basetest:closeBrowser:browser is quit and removing browser instance...." );
		}
		
		
		@BeforeSuite
		public static void setup() {
			report = ReportManager.getInstance();
			logger.debug("Basetest:setup: initializing report manager.." );
		}
		@AfterSuite
		public static void tearDown() {
			report.flush();
			logger.debug("Basetest:tearDown: flushing the report.." );
		}

		public static WebDriver getBrowserDriver(String bName, boolean headless) {
			String browserName = bName.toLowerCase();
			WebDriver driver = null;
			switch (browserName) {
			case "chrome":
				if (headless) {
					ChromeOptions co = new ChromeOptions();
					co.addArguments("--headless");
					driver = new ChromeDriver(co);
				} else {
					driver = new ChromeDriver();
				}
				break;

			case "firefox":
				driver = new FirefoxDriver();
				break;

			case "edge":
				driver = new EdgeDriver();
				break;

			case "safari":
				driver = new SafariDriver();
				break;
				
			default:
				System.out.println("Only supported drivers are chrome, safari, edge, firefox");
			}
			return driver;
		}
	

	}



