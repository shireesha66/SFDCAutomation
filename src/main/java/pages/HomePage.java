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

	@FindBy(xpath="//li[@id='home_Tab']//a[1]")
	public WebElement HomeTab;
	
	@FindBy(xpath=" //h1[@class='currentStatusUserName']//a[1]")
	public WebElement currentUserName;
	
	@FindBy(xpath="(//img[@title='Edit Profile'])[1]")
	public WebElement editButton;
	
	@FindBy(xpath="//a[@aria-controls='TabPanel:0:Body:1']")
	public WebElement abouttabiframe;
	
	@FindBy(xpath="//input[@value='Save All']")
	public WebElement saveallButton;
	
	@FindBy(xpath="//input[contains(@class,'lastName zen-inputFull')]")
	public WebElement lastname;
	
	@FindBy(xpath="//a[@aria-controls='TabPanel:0:Body:2']")
	public WebElement contactTabIframe;
	
	@FindBy(xpath="//iframe[@frameborder='no']") 
	public WebElement iframe;
	
	//35TC
	
	@FindBy(xpath="//img[@title='All Tabs']") 
	public WebElement plusTab;
	
	@FindBy(xpath="//input[@title='Customize My Tabs']")
	public WebElement customizeMyTab;
	
	@FindBy(xpath="(//td[@class='selectCell']//select)[2]")
	public WebElement selectTabBox;
	
	@FindBy(xpath="//option[@value='Chatter']")
	public WebElement chatterfromselectedTabs;
	
	
	@FindBy(xpath="//img[@alt='Remove']")
	public WebElement removeButton;
	
	@FindBy(xpath="//input[@class='btn primary']")
	public WebElement saveButton;
	
	@FindBy(xpath="userNavLabel")
	public WebElement Usermenubutton;
	
	@FindBy(xpath="//a[@title='Logout']")
	public WebElement logoutfromusermenu;
	
	@FindBy(xpath="//a[normalize-space(text())='Chatter']")
	public WebElement chatterTabOnHomePage;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement login;
	
	@FindBy(xpath="(//input[@aria-describedby='error'])[1]")
	public WebElement username;
	
	@FindBy(xpath="(//input[@aria-describedby='error'])[2]")
	public WebElement password;
	
	
	
	//TC36
	@FindBy(xpath="//span[@class='pageDescription']//a[1]")
	public WebElement datelinkOnHomePage;
	
	@FindBy(xpath="//a[normalize-space(text())='8:00 pm']")
	public WebElement eightpmlink;
	
	@FindBy(xpath="//img[@title='Subject Combo (New Window)']")
	public WebElement subjectComboIcon;
	
	@FindBy(xpath="//a[@href='javascript:pickValue(4);']")
	public WebElement others;
	
	@FindBy(xpath="(//input[@name='save'])[1]")
	public WebElement save;
	
	@FindBy(xpath="//input[@value='9:00 pm']")
	public WebElement ninePmTime;
	
	@FindBy(xpath="//input[@id='EndDateTime_time']")
	public WebElement endtimeField;
	
	@FindBy(xpath="//span[@class='event_00UdM000000rjJx']")
	public WebElement otherCalendar;
	
	//tc37
	
	@FindBy(xpath="//a[normalize-space(text())='4:00 pm']")
	public WebElement fourPm;
	
	@FindBy(xpath="//div[normalize-space(text())='7:00 pm']")
	public WebElement sevenPmEndDropDown;
	
	@FindBy(xpath="(//input[@type='checkbox'])[2]")
	public WebElement recurrence;
	
	@FindBy(xpath="//input[@value='ftw']")
	public WebElement weeklyRadioButton;
	
	@FindBy(name="RecurrenceEndDateOnly")
	public WebElement EndDateBox;
	
	@FindBy(xpath="//td[@id='topButtonRow']//input[@title='Save']")
	public WebElement savebtn;
	
	//tc08
	

	@FindBy(xpath="//a[@class='debugLogLink menuButtonMenuLink']")
	public WebElement developerConsole;
	

	@FindBy(xpath="//td[@id='topButtonRow']//input[@title='Save']")
	public WebElement close;
	
	
	
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
	
	
public ContactsPage ClickOnplusTab(WebDriver driver) {
		
		WaitUtils.waitForElement(driver, plusTab);
		plusTab.click();
		
		return new ContactsPage(driver);
	}



	
	
	
	
}
