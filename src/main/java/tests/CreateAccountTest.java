package tests;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import listeners.TestListeners;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.FileUtils;
import utils.WaitUtils;

@Listeners(TestListeners.class)

public class CreateAccountTest extends BaseTest {

	LoginPage lp;
	HomePage hp;
	CreateAccountPage cap;
	UserMenuPage ump;
	WebDriver driver;
	
	
	
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
		// cap = new CreateAccountPage(driver); 
		
		}

   @AfterMethod
	public void postCondition() {
		driver.quit();
	}
	
	
  // @Test
   public void createNewAccount_TC10() {
		ExtentTest test2 = threadLocalTest.get();
		cap = new CreateAccountPage(driver); 
		cap.CreateAccountPagenavigate(driver);
		
		cap.NewAccountButton.click();
		cap.AccountName.sendKeys("Home");
		cap.save.click();
		cap.UserPageDescription(driver);
		
	}
	
	@Test
	public void createNewViewAccount_TC11(Method name) throws FileNotFoundException, IOException {
		ExtentTest test2 = threadLocalTest.get();
		cap = new CreateAccountPage(driver); 
		cap.CreateAccountPagenavigate(driver);
		cap.CreateNewView.click();
		WaitUtils.waitForElement(driver,cap.ViewUniqueName);
		String VewName = FileUtils.CreateAccountPagePropertiesfile("View.Name");
	    String VewUniqueName = FileUtils.CreateAccountPagePropertiesfile("View.UniqueName");
	    cap.ViewName.clear();
		cap.ViewName.sendKeys(VewName);
		cap.ViewUniqueName.clear();
		cap.ViewUniqueName.sendKeys(VewUniqueName);
		cap.saveViewNmeButton.click();
		//cap.NewlyAddedViewDropdown(driver);
		
	}
	
	
	//@Test
	public void EditAccount_TC12(Method name) {
		ExtentTest test2 = threadLocalTest.get();
		cap.SelectingAccountToEdit(driver);
		cap.FieldOperatorValueSelection(driver);
		cap.AddingSelectfieldToAvailableField(driver);
		
		
	}
}


	


