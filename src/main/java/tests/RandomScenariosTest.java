package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ContactsPage;
import pages.HomePage;
import pages.LeadsPage;
import pages.LoginPage;
import pages.RandomScenariosPage;
import utils.FileUtils;
import utils.WaitUtils;

public class RandomScenariosTest {
	
	LoginPage lp;
	HomePage hp;
	WebDriver driver;
	LeadsPage lead;
	ContactsPage con;
	
	
	@BeforeMethod
	public void preConditions() throws FileNotFoundException, IOException  {
		driver = BaseTest.getBrowserDriver("chrome", false);
		System.out.println("WebDriver instance: " + driver);

		System.out.println(utils.FileUtils.readLoginPropertiesFile("prod.url"));
        driver.get( FileUtils.readLoginPropertiesFile("prod.url"));
		lp= new LoginPage(driver);
		String Uname = FileUtils.readLoginPropertiesFile("valid.username");
		String pass = FileUtils.readLoginPropertiesFile("valid.password");
		hp = lp.loginToApp(driver, Uname, pass);
		
	}

   @AfterMethod
	public void postCondition() {
		driver.quit();
	}
   
   
   //@Test
   public void VerifyUserName_TC33() {
	    WaitUtils.waitForElement(driver, hp.HomeTab);
	    hp.HomeTab.click();
	    WaitUtils.waitForElement(driver, hp.currentUserName);
	   String username1= hp.currentUserName.getText();
	   String username2= hp.userMenu.getText();
	   if(username1.equals(username2)) {
		   System.out.println(" both have same user name");
	   }else {
		   System.out.println("not same");
	   }
	   
   }
   
  // @Test
   public void VerifyEditedLastName_TC34() throws InterruptedException {
	   WaitUtils.waitForElement(driver, hp.HomeTab);
	    hp.HomeTab.click();
	    WaitUtils.waitForElement(driver, hp.currentUserName);
	    hp.currentUserName.click();
	    hp.editButton.click();
	    driver.switchTo().frame(hp.iframe);
	    WaitUtils.waitForElement(driver, hp.abouttabiframe);
	    hp.abouttabiframe.click();
	    WaitUtils.waitForElement(driver, hp.lastname);
	   hp.lastname.sendKeys("abcd");
	    hp.saveallButton.click();
	    driver.switchTo().defaultContent();
   }
   
  // @Test
   public void VerifytheTabCustomization_TC35() throws InterruptedException, FileNotFoundException, IOException {
	   WaitUtils.waitForElement(driver, hp.HomeTab);
	    hp.HomeTab.click();
	    hp.ClickOnplusTab(driver);
	    WaitUtils.waitForElement(driver, hp.customizeMyTab);
	    hp.customizeMyTab.click();
	    WaitUtils.waitForElement(driver, hp.selectTabBox);
	    hp.selectTabBox.click();
	    hp.chatterfromselectedTabs.click();
	    hp.removeButton.click();
	    hp.saveButton.click();
	    WaitUtils.waitForElement(driver, hp.HomeTab);
	    hp.HomeTab.click();
	    WaitUtils.waitForElement(driver, hp.userMenu);
	    hp.clickUserMenu();
		hp.logoutfromusermenu.click();
		WaitUtils.waitForElement(driver, hp.login);
		hp.username.clear();
		hp.username.sendKeys("siri@enexus.com");
		hp.password.clear();
		hp.password.sendKeys("yandapally66");
		hp.login.click();
		WaitUtils.waitForElement(driver, hp.plusTab);
	    if(hp.chatterTabOnHomePage.isDisplayed()) {
	    	System.out.println("chatter Tab Not removed");
	    	}else {
	    		System.out.println("chatter tab removed, customizeMytab working");
	    	}
	   
   }
   
  // @Test
   public void BlockingAnEventInCalender_TC36() {
	   WaitUtils.waitForElement(driver, hp.HomeTab);
	   hp.HomeTab.click();
	   hp.datelinkOnHomePage.click();
	   hp.eightpmlink.click();
	   WaitUtils.waitForElement(driver, hp.subjectComboIcon);
	   hp.subjectComboIcon.click();
	   Set<String> windowHandles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		windowHandles.remove(currentHandle);
		String newHandle = windowHandles.iterator().next();
		driver.switchTo().window(newHandle);
		hp.others.click();
	   driver.switchTo().window(currentHandle);
	   hp.endtimeField.click();
	   hp.ninePmTime.click();
	   hp.save.click();
	   WaitUtils.waitForElement(driver, hp.otherCalendar);
	   if(hp.otherCalendar.isDisplayed()) {
		   System.out.println("event blocked");
	   }else {
		   System.out.println("event not blocked");
	   }
	   
   }
   
   
   @Test
   public void BlockingAnEventWeeklyReccurense_TC37() {
	   WaitUtils.waitForElement(driver, hp.HomeTab);
	   hp.HomeTab.click();
	   hp.datelinkOnHomePage.click();
	   hp.fourPm.click();
	   WaitUtils.waitForElement(driver, hp.subjectComboIcon);
	   hp.subjectComboIcon.click();
	   Set<String> windowHandles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		windowHandles.remove(currentHandle);
		String newHandle = windowHandles.iterator().next();
		driver.switchTo().window(newHandle);
		hp.others.click();
	   driver.switchTo().window(currentHandle);
	   hp.endtimeField.click();
	   hp.sevenPmEndDropDown.click();
	   hp.recurrence.click();
	   hp.weeklyRadioButton.click();
	   WaitUtils.waitForElement(driver, hp.EndDateBox);
	   hp.EndDateBox.clear();
	   hp.EndDateBox.sendKeys("02/04/2025");
	   hp.savebtn.click();
	  String currentUrl=driver.getCurrentUrl();
	  System.out.println(currentUrl);
	  String ActualUrl="https://enexus3-dev-ed.develop.my.salesforce.com/00U/c?md3=78&md0=2025";
	  if(currentUrl.equals(ActualUrl)) {
		  System.out.println("day view page displayed");
	  }else {
		  System.out.println("not displayed");
	  }
   }
   

}
