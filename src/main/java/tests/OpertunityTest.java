package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.util.Assert;

import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OpportunitiesPage;
import pages.UserMenuPage;
import utils.FileUtils;
import utils.WaitUtils;

public class OpertunityTest{
	
	
	LoginPage lp;
	HomePage hp;
	
	UserMenuPage ump;
	WebDriver driver;
	OpportunitiesPage opty;


	
	
	
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
		 opty = new OpportunitiesPage(driver); 
		 //newopty= new new_optyPage(driver);
		
		}

   @AfterMethod
	public void postCondition() {
		driver.quit();
	}
   
  // @Test
   public void Verify_Opportunity_Dropdown_TC15(Method name) throws FileNotFoundException, IOException {
	   OpportunitiesPage opty= hp.ClickOnOpportunities(driver);
	   WaitUtils.waitForElement(driver, opty.opportunity_dropdown);
	  
	   boolean result = opty.opportunityDropdownList();
	    Assert.assertTrue(result, "Opportunity dropdown values do not match the expected list.");
	 
	   }
   
 //  @Test
   public void create_NewOpportunity_TC16(Method name) throws InterruptedException, FileNotFoundException, IOException {
	   OpportunitiesPage opty= hp.ClickOnOpportunities(driver);
	   WaitUtils.waitForElement(driver, opty.new_button);
	   opty.new_button.click();
	   WaitUtils.waitForElement(driver, opty.opportunityName);
	   opty.opportunityName.sendKeys("efgh");
	   opty.closeDate.click();
	   opty.Date13Button.click();
	   opty.stage.click();
	   opty.qualification_stage.click();
	   String currentUrl = driver.getCurrentUrl();
	   opty.save.click();
	   WaitUtils.waitForElementToBeInvisible(driver, opty.save);
	   String newUrl = driver.getCurrentUrl();
	  if(!currentUrl.equals(newUrl)){
		  Assert.assertTrue(true, "new page created");
		  System.out.println("new page created");
		  
		  }else {
			  Assert.assertFalse(false,"new page not created");
			  System.out.println("new page not created");
		  }
	
   }
   
  // @Test
   public void TestOpportunity_pipelinereport_TC17(Method name) {
	   OpportunitiesPage opty= hp.ClickOnOpportunities(driver);
	   WaitUtils.waitForElement(driver, opty.opportunityPipeline);
	   opty.opportunityPipeline.click();
	   WaitUtils.waitForElement(driver, opty.completestatus);
	   if(opty.completestatus.isDisplayed()) {
		   System.out.println("report pipeline displayed");
	   }
	   
   }
   
  // @Test
   public void stuckOpportunity_TC18() throws InterruptedException {
	   OpportunitiesPage opty= hp.ClickOnOpportunities(driver);
	   WaitUtils.waitForElement(driver, opty.opportunityPipeline);
	   String title1 = driver.getCurrentUrl();
       opty.stuckOpportunity.click();
       Thread.sleep(2000);
       String title2 = driver.getCurrentUrl();
       if(!title1.equals(title2)){
 		  Assert.assertTrue(true, "new page created");
 		  System.out.println("new report page created");
 		  
 		  }else {
 			  Assert.assertFalse(false,"new page not created");
 			  System.out.println("new report page not created");
 		  }
        }

   @Test
   public void QuarterlySummeryReprt_TC19() {
	   OpportunitiesPage opty= hp.ClickOnOpportunities(driver);
	   WaitUtils.waitForElement(driver, opty.opportunityPipeline);
	   String Url1 = driver.getCurrentUrl();
	   opty.interval.click();
	   opty.CurrentandNextFq.click();
	   WaitUtils.waitForElement(driver, opty.include);
	   opty.include.click();
	   opty.openopportunity.click();
	   opty.runreport.click();
	   WaitUtils.waitForElementToBeInvisible(driver, opty.runreport);
	   String Url2= driver.getCurrentUrl();
	   
	   if(!Url1.equals(Url2)) {
		   Assert.assertTrue(true, "new page created");
		   System.out.println("QuarterlySummeryReprt is generated");
	   }else {
		   Assert.assertTrue(false, "new page not created");
		   System.out.println("QuarterlySummeryReprt not generated");
		   
	   }
	   
	   
	   
	   
	   
   }
	   
   }
   


	   
  
   
   


