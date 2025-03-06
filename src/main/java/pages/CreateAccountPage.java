package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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
	
	
	@FindBy(xpath="//input[@class='btn primary'][1]")
	public 	WebElement saveViewNmeButton ;
	
	@FindBy(css="select[name='fcf']")
	public 	WebElement AddedViewDropdown ;
	
	@FindBy(xpath="//a[normalize-space(text())='Edit']")
	public 	WebElement EditButton;
	
	
	@FindBy(xpath="(//td[@class='dataCol'])[1]")
	public WebElement EditViewViewname;
	
	
	@FindBy(xpath="(//select[@class='column'])[1]")
	public WebElement Field ;
	
	
	@FindBy(xpath="//select[@title='Operator 1']")
	public WebElement operator;
	
	@FindBy(xpath="//input[@id='fval1']")
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
		//HomePage hp = new HomePage(driver); 
		CreateAccountPage cap = hp.clickOnAccountTab(driver);
		cap.AddedViewDropdown.click();
		Select dropdown = new Select(AddedViewDropdown);
		dropdown.selectByIndex(2);
	}
	
	public void FieldOperatorValueSelection(WebDriver driver) {
		//HomePage hp = new HomePage(driver); 
		//CreateAccountPage cap = hp.clickOnAccountTab(driver);
	
		this.EditButton.click();
		//cap.EditButton.click();
		WaitUtils.waitForElement(driver, Field);
		//cap.Field.click();
		this.Field.click();
		Select dropdown = new Select(Field);
		dropdown.selectByIndex(0);
		WaitUtils.waitForElement(driver, operator);
		//cap.operator.click();
		this.operator.click();
		Select dropdown2 = new Select(Field);
		dropdown2.selectByIndex(3);
		WaitUtils.waitForElement(driver,value );
		//cap.value.sendKeys("a");
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
				break;
			}
		}
		return Element_available = true;
	}
		
		
		
	}

	



