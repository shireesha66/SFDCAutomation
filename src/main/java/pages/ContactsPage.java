package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage {

	public ContactsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath=" //input[@name='new']")
	public WebElement newbutton;
	
	@FindBy(xpath=" //input[@id='name_lastcon2']")
	public WebElement lastname;
	
	@FindBy(xpath=" //input[@id='con4']")
	public WebElement accountname;
	
	
	@FindBy(xpath=" (//input[@class='btn'])[1]")
	public WebElement save;
	
	@FindBy(id="con2_ileinner")
	public WebElement name;
	
	@FindBy(xpath="//a[normalize-space(text())='Create New View']")
	public WebElement createnewview;
	
	@FindBy(id="fname")
	public WebElement viewname ;
	
	@FindBy(id="devname")
	public WebElement viewuniquename ;
	
	
	@FindBy(xpath="(//input[@name='save'])[1]")
	public WebElement savebutton ;
	
	@FindBy(xpath="//select[@class='title']")
	public WebElement title;
	
	@FindBy(id="hotlist_mode")
	public WebElement dRopdown;
	
	@FindBy(xpath="//select[@title='Display Selection']")
	public WebElement recentlycreated;
	
	
	@FindBy(xpath="(//th[@scope='row']//a)[1]")
	public WebElement lastname2;
	
	@FindBy(xpath="//option[@value='00BdM00000NdwGr']")
	public WebElement mycontactsfromdropdown;
	
	@FindBy(xpath="//select[@id='fcf']")
	public WebElement viewDropdown;
	
	@FindBy(xpath="(//div[@class='errorMsg'])[1]")
	public WebElement errormsg;
	
	@FindBy(xpath="(//input[@value='Cancel'])[1]")
	public WebElement cancel;
	
	@FindBy(xpath="(//input[@name='save_new'])[1]")
	public WebElement saveandnew;
	
	
	
	
	
	
	
	
	
	

}
