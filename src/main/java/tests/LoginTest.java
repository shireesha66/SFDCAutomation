package tests;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;
import utils.FileUtils;
import utils.WaitUtils;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import listeners.TestListeners;


@Listeners(TestListeners.class)
public class LoginTest extends BaseTest{
	

	@Parameters("bName")
	@Test(enabled = true, priority = 1)
	public void loginErrorMsg_TC01(Method name) throws InterruptedException, FileNotFoundException, IOException {
		ExtentTest test2 = threadLocalTest.get();
 	    SoftAssert sa = new SoftAssert();
 		
		WebDriver driver = BaseTest.getBrowser();
		LoginPage lp = new LoginPage(driver);
		driver.get("https://login.salesforce.com");
		logger.debug("Basetest:loginErrorMsg_TC01: launched sfdc application" );
		test2.log(Status.INFO, "chrome browser launched with sfdc app");
		lp.username.sendKeys("siri@enexus.com");
		lp.login.click();
		test2.log(Status.INFO, "login button clicked");
		WaitUtils.waitForElement(driver, lp.errorMsg);
		sa.assertTrue(lp.verifyErrorMsg(driver), "Error message should be validated");
		sa.assertAll();
		
		
	}
	
	@Test(priority = 2)
	public void rememberMe_TC02(Method name) throws InterruptedException {
		ExtentTest test2 = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get("https://login.salesforce.com");
		LoginPage lp = new LoginPage(driver);
		HomePage hp = lp.loginToApp(driver, "siri@enexus.com", "yandapally66");
		WaitUtils.waitForElement(driver, hp.userMenu);
		lp = hp.logoutFromApp(driver);
		WaitUtils.waitForElement(driver, lp.password);
		String actualUsername = lp.getSavedUsername();
		

	}


	
	//@Test(enabled = true)
	public void loginErrorMsg_tc01(Method name) throws FileNotFoundException, IOException {
		//SoftAssert sa = new SoftAssert();
		WebDriver driver = new ChromeDriver();
		LoginPage lp = new LoginPage(driver); 
		 driver.get( FileUtils.readLoginPropertiesFile("prod.url"));
		 WaitUtils.waitForElement(driver, lp.password);
		assertTrue(lp.verifyLoginPage(driver), "failed to verify login page loading");
		lp.username.sendKeys("siri@enexus.com");
		lp.password.clear();
		lp.login.click();
		WaitUtils.waitForElement(driver, lp.errorMsg);
		assertTrue(lp.verifyErrorMsg(driver), "failed to verify Error Msg verification");
		System.out.println("error message verified");
		driver.quit();
		
	}
	
	
  
//	@Test(enabled = true)
   public void login_tc02() throws FileNotFoundException, IOException {
   WebDriver driver = new ChromeDriver();
   LoginPage lp = new LoginPage(driver); 
   HomePage hp = new HomePage(driver);
   driver.get( FileUtils.readLoginPropertiesFile("prod.url"));
   WaitUtils.waitForElement(driver, lp.password);
   String Uname = FileUtils.readLoginPropertiesFile("valid.username");
   String pass = FileUtils.readLoginPropertiesFile("valid.password");
   lp.username.sendKeys(Uname);
   lp.password.sendKeys(pass);
   lp.login.click();
   WaitUtils.waitForElement(driver, hp.userMenu);
   if(hp.userMenu.isDisplayed()) {
	   System.out.println("home page displayed");
   }else {
	   System.out.println("home page not displayed");
   }
   driver.quit();
  }


 //@Test(enabled = true)
public void rememberMeCheckbox_tc03() throws FileNotFoundException, IOException, InterruptedException {
	   WebDriver driver = new ChromeDriver();
	   LoginPage lp = new LoginPage(driver); 
	   HomePage hp = new HomePage(driver);
	   driver.get( FileUtils.readLoginPropertiesFile("prod.url"));
	   WaitUtils.waitForElement(driver, lp.username);
	   String Uname = FileUtils.readLoginPropertiesFile("valid.username");
	   String pass = FileUtils.readLoginPropertiesFile("valid.password");
	   lp.username.sendKeys(Uname);
	   lp.password.sendKeys(pass);
	   lp.rememberMeCheckbox();
	   lp.login.click();
	   WaitUtils.waitForElement(driver, hp.userMenu);
	   hp.userMenu.click();
	   WaitUtils.waitForElement(driver, hp.logout);
	   hp.logout.click();
	   WaitUtils.waitForElement(driver, lp.password);
	   String actualUsername = lp.getSavedUsername();
	   
	   if(actualUsername.equals(Uname)) {
		  System.out.println("username displayed");
	   }else {
		  
		  System.out.println("not displayed");
	   }
       driver.quit();
}


//@Test(enabled = true)
public void forgotpassword_tc04a() throws FileNotFoundException, IOException {
	   WebDriver driver = new ChromeDriver();
	   LoginPage lp = new LoginPage(driver); 
	   driver.get( FileUtils.readLoginPropertiesFile("prod.url"));
	   String Uname = FileUtils.readLoginPropertiesFile("valid.username");
	   lp.username.sendKeys(Uname);
	   lp.forgotPassword.click();
	   WaitUtils.waitForElement(driver, lp.continueButton);
	   lp.usernameRequest.sendKeys(Uname);
	   lp.continueButton.click();
	   
	   if(lp.forgotpasswordform.isDisplayed()) {
		   System.out.println(" forgot password form displayed");
      }else {
	  System.out.println("forgot password form not displayed");
}
	   driver.quit();
}

//@Test(enabled = true)
public void wrongcredintials_tc04b() throws FileNotFoundException, IOException {
	   WebDriver driver = new ChromeDriver();
	   LoginPage lp = new LoginPage(driver); 
	   driver.get( FileUtils.readLoginPropertiesFile("prod.url"));
	   HomePage hp = lp.loginToApp(driver, "siri@enexus.com", "yandapally");
	   WaitUtils.waitForElement(driver,lp.errorMsg);
	   //lp=hp.logoutFromApp(driver);
		String actualErrorMsg = lp.errorMsg.getText();
		String expectedErrorMsg = "Please enter your password.Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		if(actualErrorMsg.equals(expectedErrorMsg)) {
			System.out.println("PASSED");
		}else {
			System.out.println("FAILED");
		}
		driver.quit();
	}
}

