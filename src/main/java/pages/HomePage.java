package pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.FileUtils;
import utils.WaitUtils;


/**
 * 
 */
public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="userNavButton")
	public WebElement userMenu;
	
	@FindBy(linkText="Logout")
	public WebElement logout;
	
	@FindBy(xpath= "//div[@id='userNavButton']")
    public List<WebElement>userMenuOptions; 
	
	@FindBy(xpath="//*[@id='userNav-menuItems']/a[1])")
	public WebElement myProfileOptions;
	
	@FindBy(xpath="//*[@id='userNav-menuItems']/a[2])")
	public WebElement mySettingsOptions;
	
	@FindBy(xpath="//*[@id=\"Account_Tab\"]/a")
	public WebElement AccountTab;
	
	@FindBy(xpath="//li[@id='Opportunity_Tab']")
	public WebElement Opportunities;
	
	@FindBy(xpath="//a[@title='Leads Tab']")
	public WebElement LeadsTab;
	
	
	@FindBy(xpath="//li[@id='Contact_Tab']")
	public WebElement ContactsTab;

	
	
	/*public boolean verifyUserMenuOptions() throws FileNotFoundException, IOException {
		boolean isOptionsVerified = true;
		String[] expectedUserMenuOptions = FileUtils.readHomePagePropertiesFile("usermenu.options").split(",");
		if (expectedUserMenuOptions.length != this.userMenuOptions.size()) {
			isOptionsVerified = false;
		}
*/
	public boolean verifyUserMenuOptions() throws FileNotFoundException, IOException {
		boolean isOptionsVerified = true;
	   String[] expectedUserMenuOptions = FileUtils.readHomePagePropertiesFile("usermenu.options").split(",");
	   if(expectedUserMenuOptions.length != this.userMenuOptions.size()){
			isOptionsVerified = false;
			}
	   for(int i=0;i<expectedUserMenuOptions.length;i++) {
		   String actualOptionValue = this.userMenuOptions.get(i).getText();
		   if(!actualOptionValue.equals(expectedUserMenuOptions[i])) {
			   System.out.println("actualOptionValue " +actualOptionValue+" expectedUserMenuOptions "+expectedUserMenuOptions[i]);

			   isOptionsVerified = false;
		   }
	   }
	   return isOptionsVerified;
	}
		
	 
	/**
	 * @return 
	 * 
	 */
	public UserMenuPage navigateToMyProfile(WebDriver driver) {
		if(this.myProfileOptions.isDisplayed()) {
			  this.myProfileOptions.click();
			  }else {
			  System.out.println("HomePage: navigateToMyProfile: myProfileOptions is not displayed ");
			  }
		return new UserMenuPage(driver);
		
		  }
	public UserMenuPage navigateToMySettings(WebDriver driver) {
		if(this.mySettingsOptions.isDisplayed()) {
			  this.mySettingsOptions.click();
			  }else {
			  System.out.println("HomePage: navigateToMySettings: mysettingsOptions is not displayed ");
			  }
		return new UserMenuPage(driver);
		
		  }
	
	
	public void clickUserMenu() {
		if(this.userMenu.isDisplayed()) {
			this.userMenu.click();
	}else {
		System.out.println("HomePage: clickUserMenu: usermenu is not displayed ");
	   }
	}
	  
	/**
	 * @param driver
	 * @return
	 */
	public LoginPage logoutFromApp (WebDriver driver) {
		if(this.userMenu.isDisplayed()) {
		this.userMenu.click();
      this.logout.click();
	} else {
		System.out.println("usermenu not visible");
	}
		return new LoginPage(driver);
}
	
	//account tab click method
	
	public CreateAccountPage clickOnAccountTab(WebDriver driver) {
		WaitUtils.waitForElement(driver, AccountTab);
        AccountTab.click();
        return new CreateAccountPage(driver);
    }


	public OpportunitiesPage ClickOnOpportunities(WebDriver driver) {
		WaitUtils.waitForElement(driver, Opportunities);
		Opportunities.click();
        return new OpportunitiesPage(driver);
	}
	
	public LeadsPage ClickOnLeadsTab(WebDriver driver) {
		WaitUtils.waitForElement(driver, LeadsTab);
		LeadsTab.click();
		
		return new LeadsPage(driver);
		
	}


	public ContactsPage ClickOncontactsTab(WebDriver driver) {
		
		WaitUtils.waitForElement(driver, ContactsTab);
		ContactsTab.click();
		
		return new ContactsPage(driver);
	}
	
	
	
}
