package pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.FileUtils;
import utils.WaitUtils;

public class CreateAccountPage extends BasePage {

	public CreateAccountPage(WebDriver driver) {
		super(driver);
		}

	
	@FindBy(xpath = "//input[@name='new'] ")
	public WebElement NewAccountButton;
	
	@FindBy(xpath="//input[@id='acc2']")
	public WebElement AccountName;
	
	@FindBy(xpath="//input[@tabindex='34']")
	public WebElement save;
	
	@FindBy (xpath="// h2[@class=\"pageDescription\"]")
	public WebElement AccountPageDescription;
	
	@FindBy(xpath="//a[normalize-space(text())='Create New View']")
	public 	WebElement CreateNewView;
	
	@FindBy(xpath="//input[@id='fname']")
	public 	WebElement ViewName ;
	
	@FindBy(xpath="//input[@id='devname']")
	public 	WebElement ViewUniqueName ;
	
	
	@FindBy(xpath="//input[@data-uidsfdc='3']")
	public 	WebElement saveViewNmeButton ;
	
	@FindBy(xpath="//select[@title='View:']")
	public 	WebElement AddedViewDropdown ;
	
	@FindBy(xpath="//a[normalize-space(text())='Edit']")
	public 	WebElement EditButton;
	
	
	@FindBy(xpath="(//td[@class='dataCol'])[1]")
	public WebElement EditViewViewname;
	
	
	@FindBy(xpath="//select[@data-uidsfdc='8']")
	public WebElement Field ;
	
	@FindBy(xpath="(//select[@data-uidsfdc='8']//option)[2]")
	public WebElement AccountNameDd ;
	
	
	@FindBy(xpath="//select[@title='Operator 1']")
	public WebElement operator;
	
	@FindBy(css="select#fop1>option:nth-of-type(5)")
	public WebElement contains;
	
	@FindBy(xpath="//input[@title='Value 1']")
	public WebElement value;
	
	
	@FindBy(xpath="//label[normalize-space(text())='Available Fields']")
	public WebElement AvailableFields;
	
	@FindBy(xpath="//option[@value='ACCOUNT.LAST_ACTIVITY'])[1]")
	public WebElement lastActivity;
	
	@FindBy(xpath="//select[@id='colselector_select_1']")
	public WebElement SelectedFields;
	
	@FindBy(xpath="//table[@class='layout']/tbody[1]/tr[1]/td[3]/select[1]/option[7]")
	public WebElement lastActivityOnSelectedField;
	
	
	@FindBy(xpath="(//img[@title='Add'])[1]")
	public WebElement addButton;
	
	@FindBy(xpath="(//input[@value=' Save '])[2]")
	public WebElement SaveButton;
	
	
	//tc13
	@FindBy(xpath="//a[contains(text(),'Merge Accounts')]")
	public WebElement MergeAccounts;
	
	@FindBy(id="srch")
	public WebElement SearchAccountBox;
	
	@FindBy(name="srchbutton")
	public WebElement FindAccounts;
	
	@FindBy(xpath="//input[@id='cid0']")
	public WebElement checkboxOne;
	
	@FindBy(xpath="//input[@id='cid1']")
	public WebElement checkBoxtwo;
	
	@FindBy(xpath="//div[contains(@class,'pbTopButtons')]//input[contains(@title,'Next')]")
	public WebElement next;
	
	@FindBy(xpath="(//input[@value=' Merge '])[1]")
	public WebElement merge;
	
	//tc14
	
	@FindBy(xpath="//a[normalize-space(text())='Accounts with last activity > 30 days']")
	public WebElement AccountActivitymorethanthirtydays;
	
	@FindBy(xpath="//img[@id='ext-gen152']")
	public WebElement fromdate;
	
	
	@FindBy(xpath="//button[@id='ext-gen277']")
	public WebElement todayinFromDate;
	
	
	@FindBy(xpath="//img[@id='ext-gen154']")
	public WebElement toDate;
	
	
	@FindBy(xpath="(//td[@class='x-date-bottom']//table)[2]")
	public WebElement todayInToDate;
	
	
	@FindBy(xpath="(//td[@class='x-btn-mc'])[1]")
	public WebElement savereport;
	
	
	@FindBy(xpath="(//input[@class='x-form-text x-form-field'])[1]")
	public WebElement reportname;
	
	
	@FindBy(xpath="(//input[@class='x-form-text x-form-field'])[2]")
	public WebElement ReportUniqueName;
	
	@FindBy(xpath="//button[normalize-space(text())='Save and Run Report']")
	public WebElement saveandRunreport;
	
	
	HomePage hp;
	
	public void CreateAccountPagenavigate(WebDriver driver) {
		 HomePage hp = new HomePage(driver); 
		CreateAccountPage cap = hp.clickOnAccountTab(driver);
		if(cap.NewAccountButton.isDisplayed()) {
			System.out.println("CreateAccountPage: CreateAccountPagenavigate : account page displayed");
		} else {
			System.out.println("CreateAccountPage: CreateAccountPagenavigate : account page not displayed");
		}
	}
	
	
	public void UserPageDescription(WebDriver driver) {
		 HomePage hp = new HomePage(driver); 
			CreateAccountPage cap = hp.clickOnAccountTab(driver);
			String actualText = cap.AccountPageDescription.getText();
			String expectedText = "Home";
			 Assert.assertEquals(actualText, expectedText, "Text does not match!"); {
				System.out.println("CreateAccountPage:User PageDescription : new account page displayed with given account name");
				}
					
	}
	
	
	public boolean NewlyAddedViewDropdown(WebDriver driver) {
		HomePage hp = new HomePage(driver); 
		CreateAccountPage cap = hp.clickOnAccountTab(driver);
		
		cap.CreateNewView.click();
		
		boolean isNewView = false;
		Select dropdownOptions = new Select(AddedViewDropdown); 
		WaitUtils.waitForElement(driver,AddedViewDropdown);
		 List<WebElement> elements = dropdownOptions .getOptions();
	     for(int i=0; i<elements.size(); i++) {
		if(elements.get(i).getText().equals("siri")) {
			System.out.println("siri is added");	
		}if(elements.get(i).getText().equals("reddy")) {
			System.out.println("reddy added");
			
	     }else {
			System.out.println("practice is not added");
		}
	
}
		 return isNewView; 
			
		}
	
	
	//edit account
	
	public void SelectingAccountToEdit(WebDriver driver) {
		HomePage hp = new HomePage(driver); 
		CreateAccountPage cap = hp.clickOnAccountTab(driver);
		cap.AddedViewDropdown.click();
		Select dropdown = new Select(AddedViewDropdown);
		dropdown.selectByIndex(2);
	}
	
	public void FieldOperatorValueSelection(WebDriver driver) {
		this.EditButton.click();
		WaitUtils.waitForElement(driver, Field);
		this.ViewName.sendKeys("okksjdjh");
		this.Field.click();
		Select dropdown = new Select(Field);
		dropdown.selectByIndex(1);
		WaitUtils.waitForElement(driver, operator);
		this.operator.click();
		Select dropdown2 = new Select(Field);
		dropdown2.selectByIndex(4);
		WaitUtils.waitForElement(driver,value );
		
		this.value.sendKeys("a");
	}
	
	public boolean AddingSelectfieldToAvailableField(WebDriver driver) {
		WaitUtils.waitForElement(driver, AvailableFields);
		
		Select Available_dropdown = new Select(AvailableFields);
		List<WebElement> Available_Fields_dropdown_options =  Available_dropdown.getOptions();

		boolean Element_available = false; //using as a reference to validate if the last activity is in available fields dropdown or not
		
		for(int i=0; i<Available_Fields_dropdown_options.size(); i++) {
			if(Available_Fields_dropdown_options.get(i).getText().equals("Last Activity")) {
				Element_available = true;
				this.addButton.click();
				System.out.println("newView displayed");
				break;
			}
		}
		return Element_available = true;
	}
		
		
	
	public boolean VerifyDropdownOptions(WebDriver driver) throws FileNotFoundException, IOException {
		WaitUtils.waitForElement(driver, AddedViewDropdown);
		
		Select AddedViewDropdown = new Select (this.AddedViewDropdown);
		List<WebElement> AddedViewDropdown_options =  AddedViewDropdown.getOptions();

		boolean Account_available = false; //using as a reference to validate if the variable is in available fields dropdown or not
		
		for(int i=0; i<AddedViewDropdown_options.size(); i++) {
			
			if(AddedViewDropdown_options.get(i).getText().equals(FileUtils.CreateAccountPagePropertiesfile("View.Name"))) {
				Account_available = true;
				System.out.println("account created");
				
				break;
			}
		}
		return Account_available = true;
	}
		
	}
		
	

	



