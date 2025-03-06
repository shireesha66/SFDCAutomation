package pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.FileUtils;

public class LeadsPage extends BasePage {

	public LeadsPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(xpath="//select[@id='fcf']")
	public WebElement viewDropdown;
	
	@FindBy(xpath="//option[@value='00BdM00000NdwGA']")
	public WebElement todayslead;
	
	@FindBy(xpath="//div[@id='userNav']")
	public WebElement usermenu;
	
	
	@FindBy(xpath="//a[@title='Logout']")
	public WebElement logout;
	
	@FindBy(xpath="//input[@type='email']")
	public WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	public WebElement login;
	
	@FindBy(xpath="//input[@title='New']")
	public WebElement newButton;
	
	@FindBy(xpath="//input[@id='name_lastlea2']")
	public WebElement lastname;
	
	@FindBy(xpath="//input[@id='lea3']")
	public WebElement companyname;
	
	@FindBy(xpath="//select[@id='lea13']")
	public WebElement leadstatus;
	
	@FindBy(xpath="//option[@value='Open - Not Contacted']")
	public WebElement OpenNotContacted; 
	
	@FindBy(xpath="(//input[@title='Save'])[1]")
	public WebElement save;
	
	@FindBy(xpath="//h2[normalize-space(text())='Lead Detail']")
	public WebElement leadDetailPage;
	
	
	
	
	
	public void leadsselectviewlist() throws FileNotFoundException, IOException {
		this.viewDropdown.click();
		Select dropdownoptions = new Select(viewDropdown); 
		List <WebElement> elements= dropdownoptions.getOptions();
		List<String>actualOptions = new ArrayList<>();
		for(WebElement list : elements) {
			actualOptions.add(list.getText().trim());
			System.out.println("actual options"+actualOptions);
		}
		
		String[] expectedOptions= FileUtils.readLeadPagePropertiesfile("view.dropdown").split(",");
      // Assert.assertEquals(actualOptions, expectedOptions, "actual and expected values are same");	
		if(expectedOptions.equals(actualOptions)){
			System.out.println("values matched");
			}else {
				System.out.println("not matched");
			}
		}

}


	
	
