package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.ContactsPage;
import pages.HomePage;
import pages.LeadsPage;
import pages.LoginPage;
import utils.FileUtils;
import utils.WaitUtils;

public class ContactsTest {

	
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
   
   
   public void createNewContact_TC25() throws FileNotFoundException, IOException {
	   ContactsPage con= hp.ClickOncontactsTab(driver);  
	   con.newbutton.click();
	   WaitUtils.waitForElement(driver, con.accountname);
	   con.lastname.sendKeys(FileUtils.readContactsPagePropertiesfile("last.name"));
	   con.save.click();
	   WaitUtils.waitForElement(driver, con.name);
	   if(con.name.equals(FileUtils.readContactsPagePropertiesfile("last.name"))) {
		   System.out.println("newaccountcreated");
	   }else {
		   System.out.println("not ctreated");
	   }
	   
	   
   }
  
   
   public void createNewViewInContactPage_TC26() throws FileNotFoundException, IOException {
	   ContactsPage con= hp.ClickOncontactsTab(driver);
	   con.createnewview.click();
	   WaitUtils.waitForElement(driver, con.viewname);
	   con.viewname.sendKeys(FileUtils.readContactsPagePropertiesfile("view.name"));
	   con.viewuniquename.sendKeys(FileUtils.readContactsPagePropertiesfile("view.uniquename"));
	   con.savebutton.click();
	   WaitUtils.waitForElement(driver, con.title);
	   
	   if(con.title.equals(FileUtils.readContactsPagePropertiesfile("view.name"))) {
		   System.out.println("createnewview created");
	   }else {
		   System.out.println("not created");
	   }
	   
	  }
   
   
   public void recentlyCreatedContactInContactPage_TC27() {
	   ContactsPage con= hp.ClickOncontactsTab(driver);
	   WaitUtils.waitForElement(driver,con.dRopdown);
	   con.dRopdown.click();
	   con.recentlycreated.isSelected();
	 }
}
