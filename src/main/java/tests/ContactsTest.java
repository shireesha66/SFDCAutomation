package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
   
 // @Test
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
  
  
 // @Test
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
   
  
 // @Test
   public void recentlyCreatedContactInContactPage_TC27() throws FileNotFoundException, IOException, InterruptedException {
	   ContactsPage con= hp.ClickOncontactsTab(driver);
	   WaitUtils.waitForElement(driver,con.dRopdown);
	   con.dRopdown.click();
	   //JavascriptExecutor js = (JavascriptExecutor) driver;
	  //  js.executeScript("arguments[2].value = 'recentlyCreatedOptionValue';", con.recentlycreated);

	  con.recentlycreated.click();
	   WaitUtils.waitForElement(driver, con.lastname2);
	   String actualurl=driver.getCurrentUrl();
	   System.out.println(actualurl);
	   String expectedurl= FileUtils.readContactsPagePropertiesfile("recentlycreated.url");
	   Thread.sleep(6000);
	   if(actualurl.equals(expectedurl)) {
		 System.out.println("recently created page opened");  
		    }else {
		    	System.out.println("not opened");
		    }
	 }
  
 // @Test
  public void MyContactsViewInContactsPage_TC28() {
	  ContactsPage con= hp.ClickOncontactsTab(driver);
	  WaitUtils.waitForElement(driver,con.viewDropdown);
	  con.viewDropdown.click();
	  con.mycontactsfromdropdown.click();
	  String actualUrl=driver.getCurrentUrl();
	  System.out.println(actualUrl);
	  String expectedUrl ="https://enexus3-dev-ed.develop.my.salesforce.com/003/o";
	  if(actualUrl.equals(expectedUrl)) {
			 System.out.println("my contacts page opened");  
			    }else {
			    	System.out.println("not opened");
			    }
	   }
  
 // @Test
  public void viewContactInContactPage_TC29() throws FileNotFoundException, IOException {
	  ContactsPage con= hp.ClickOncontactsTab(driver);
	  WaitUtils.waitForElement(driver, con.lastname2);
	  con.lastname2.click();
	  String actualurl=driver.getCurrentUrl();
	  System.out.println(actualurl);
	  String expectedUrl = FileUtils.readContactsPagePropertiesfile("contactName.URL");
	  if(actualurl.equals(expectedUrl)) {
			 System.out.println("my contacts page contact is opened");  
			    }else {
			    	System.out.println("not opened");
			    }
  }
  
 // @Test
  public void ErrorMsg_Tc30() {
	  ContactsPage con= hp.ClickOncontactsTab(driver);
	  WaitUtils.waitForElement(driver, con.createnewview);
	  con.createnewview.click();
	  con.viewuniquename.sendKeys("efgh");
	  con.savebutton.click();
	 if(con.errormsg.isDisplayed()){
		 System.out.println("error msg displayed for not giving enough information"); 
	  }else {
		  System.out.println("not displayed");
	  }
	  
	  
  }
  
 // @Test
  public void CancelButtonCNV_TC31() {
	  ContactsPage con= hp.ClickOncontactsTab(driver);
	  WaitUtils.waitForElement(driver, con.createnewview);
	  con.createnewview.click();
	  con.viewname.sendKeys("abcd");
	  con.viewuniquename.sendKeys("efgh");
	 String urlOfCNVpage = driver.getCurrentUrl();
	 con.cancel.click();
	 String urlOfConPage= driver.getCurrentUrl();
	 if(!urlOfCNVpage.equals(urlOfConPage)){
		 System.out.println("cancel button working");
	 }else {
		 System.out.println("notworking");
	 }
}
  
 @Test
  public void CheckSaveandNewButton_TC32() {
	  ContactsPage con= hp.ClickOncontactsTab(driver);
	  con.newbutton.click();
	  WaitUtils.waitForElement(driver, con.lastname);
	  con.lastname.sendKeys("indian");
	  String urlbefore = driver.getCurrentUrl();
	  con.saveandnew.click();
	  String urlafter = driver.getCurrentUrl();
	  if(!urlbefore.equals(urlafter)) {
		  System.out.println("saveandnew button working");
	  }else {
		  System.out.println("not working");
	  }
  }
}
