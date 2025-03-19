package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LeadsPage;
import pages.LoginPage;
import pages.OpportunitiesPage;
import pages.UserMenuPage;
import utils.FileUtils;
import utils.WaitUtils;

public class LeadsTest {
	
	
		LoginPage lp;
		HomePage hp;
		WebDriver driver;
		LeadsPage lead;


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
	   
	   
	 //  @Test
	   public void LeadsTab_Tc20() {
		   LeadsPage lead = hp.ClickOnLeadsTab(driver);
		   System.out.println("new leads page opened");
		   }
	   
	   
	  // @Test
	   public void LeadsSelectView_TC21() throws FileNotFoundException, IOException {
		   LeadsPage lead = hp.ClickOnLeadsTab(driver);
		   WaitUtils.waitForElement(driver, lead.viewDropdown);
		   lead.leadsselectviewlist();
		   
	   }
	   
	  // @Test
	   public void defaultview_TC22() throws FileNotFoundException, IOException{
		   LeadsPage lead = hp.ClickOnLeadsTab(driver);
		   lead.viewDropdown.click();
		   lead.todayslead.isSelected();
		   lead.usermenu.click();
		   String currenturl = driver.getCurrentUrl();
		   System.out.println("currenturl"+ currenturl);
		   lead.logout.click();
		   driver.get( FileUtils.readLoginPropertiesFile("prod.url"));
			lp= new LoginPage(driver);
		   String Uname = FileUtils.readLoginPropertiesFile("valid.username");
			String pass = FileUtils.readLoginPropertiesFile("valid.password");
			hp = lp.loginToApp(driver, Uname, pass);
			LeadsPage lead2 = hp.ClickOnLeadsTab(driver);
		   
			String defaultViewUrl= driver.getCurrentUrl();
			System.out.println("currenturl"+ defaultViewUrl);
			if(currenturl.equals(defaultViewUrl)) {
				System.out.println("default view opened");
			}else {
				System.out.println("default view not opened");
			}
		}
	   
	  // @Test
	   public void newLeadSave_TC24() {
		   LeadsPage lead = hp.ClickOnLeadsTab(driver);
		   WaitUtils.waitForElement(driver,lead.newButton );
		   lead.newButton.click();
		   WaitUtils.waitForElement(driver,lead.lastname );
		   lead.lastname.sendKeys("abcd");
		   lead.companyname.sendKeys("abcd");
		   lead.leadstatus.click();
		   lead.OpenNotContacted.isSelected();
		   lead.save.click();
		   if(lead.leadDetailPage.isDisplayed()) {
			   System.out.println("new lead page created");
		   }
		   
	   }

}
