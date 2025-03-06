
package tests;

import static org.testng.Assert.assertTrue;


import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.FileUtils;
import utils.WaitUtils;



public class UserMenuTest {
	
	String Uname;
	String pass;
	
	
	@BeforeMethod
	public void preConditions() throws FileNotFoundException, IOException {
		 Uname = FileUtils.readLoginPropertiesFile("valid.username");
	    pass = FileUtils.readLoginPropertiesFile("valid.password");
		
	   
		
	}
	
	/*@AfterMethod
	public void postCondition() {
		WebDriver driver = BaseTest.getBrowser();
		driver.quit();
	}*/
	
	
	//@Test
	
	public void userMenu_tc05() throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver = BaseTest.getBrowserDriver("chrome", false);
		 driver.get( FileUtils.readLoginPropertiesFile("prod.url"));
		 LoginPage lp= new LoginPage(driver);
		 HomePage hp = lp.loginToApp(driver, Uname, pass);
		
		WaitUtils.waitForElement(driver, hp.userMenu);
		Thread.sleep(2000);
		hp.clickUserMenu();
		assertTrue(hp.verifyUserMenuOptions(),"user menu options should be verified");
	}
	
	@Test
	public void myProfile_tc06() throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver = BaseTest.getBrowserDriver("chrome", false);
		
		 driver.get( FileUtils.readLoginPropertiesFile("prod.url"));
		
		 LoginPage lp= new LoginPage(driver);
		 HomePage hp = lp.loginToApp(driver, Uname, pass);
		 UserMenuPage ump = hp.navigateToMyProfile(driver);
		
		WaitUtils.waitForElement(driver, hp.userMenu);
		hp.clickUserMenu();
		//assertTrue(hp.verifyUserMenuOptions(),"user menu options should be verified");
		ump=hp.navigateToMyProfile(driver);
		assertTrue(ump.profilePage.isDisplayed(),"profile page should be displayed");
		ump.waitAndclickEditProfile(driver);
		assertTrue(ump.verifyContactIframeAvailability(driver),"contact Iframe should be verified");
		assertTrue(ump.verifyAboutTab(driver),"aboutTab should be verified");
		assertTrue(ump.verifyLastnameChange(),"last name should be verified");
		String msg = FileUtils.readLoginPropertiesFile("Message");
		assertTrue(ump.verifyCreatePost(driver, msg),"message should be verified");
		ump.clickOnAddPhoto(driver);
		assertTrue(ump.verifyAddPhoto(driver), "add photo should be verified");
		
	}
	
	
	//@Test
	public void mySettings_tc07() throws FileNotFoundException, IOException {
		WebDriver driver = BaseTest.getBrowser();
		 driver.get( FileUtils.readLoginPropertiesFile("prod.url"));
		 LoginPage lp= new LoginPage(driver);
		 HomePage hp = lp.loginToApp(driver, Uname, pass);
		 UserMenuPage ump = hp.navigateToMyProfile(driver);
		
		WaitUtils.waitForElement(driver, hp.userMenu);
		hp.clickUserMenu();
		assertTrue(hp.verifyUserMenuOptions(),"user menu options should be verified");
		ump=hp.navigateToMySettings(driver);
		assertTrue(ump.mySettings.isDisplayed(),"my settings page should be displayed");
		ump.waitAndclickpersonalLink(driver);
		assertTrue(ump.verifyContactIframeAvailability(driver),"contact Iframe should be verified");
		driver.switchTo().defaultContent();
		
	// adding reports	
		ump.DisplayLayoutlink.click();
		ump.CustomizedTab.click();
		assertTrue(ump.customApp.isDisplayed(),"custom app tab should be displayed");
		driver.switchTo().frame(ump.customApp);
		driver.switchTo().defaultContent();
		ump.Availabletab.click();
		ump.Add.click();
		assertTrue(ump.checkingReportstabAddedInSelectedTabs(driver),"reports tab should be verified in selected tabs");
	
  //email setup	
		WaitUtils.waitForElement(driver, ump.Emaillink);
		ump.Emaillink.click();
		ump.MyEmailSettings.click();
		ump.Emailname.clear();
		ump.Emailname.sendKeys("siri");
		ump.Emailaddress.clear();
		ump.Emailaddress.sendKeys("siri@enexus.com");
		ump.BCCradiobutton.click();
		ump.Saveonemail.click();
		
	// calendar and remainder
		ump.CalendarAndReminders.click();
		WaitUtils.waitForElement(driver, ump.ActivityRemainder);
		ump.ActivityRemainder.click();
		WaitUtils.waitForElement(driver, ump.OpenaTestRemainder);
		ump.OpenaTestRemainder.click();
		assertTrue(ump.remainderPopupWindowHndle(driver),"custom app tab should be displayed");
		driver.close();
		
}

	}
	
	
