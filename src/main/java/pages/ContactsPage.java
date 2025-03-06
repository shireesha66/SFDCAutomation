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
	
	@FindBy(xpath="//option[normalize-space(text())='Recently Created']")
	public WebElement recentlycreated;
	
	
	
	
	
	
	
	
	
	
	
	
	

}
