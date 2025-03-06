package pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.FileUtils;

public class OpportunitiesPage extends BasePage {
	
	public OpportunitiesPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//select[@id='fcf']")
	public WebElement opportunity_dropdown;
	
	@FindBy(xpath="//input[@title='New']")
	public WebElement new_button;
	
	@FindBy(xpath="(//div[@class='requiredInput']//input)[2]")
	public WebElement opportunityName;
	
	@FindBy(xpath="//label[@for='opp9']")
	public WebElement closeDate;
	
	@FindBy(xpath="//td[normalize-space(text())='13']")
	public WebElement Date13Button;
	
	@FindBy(xpath="//div[@class='requiredInput']//select[1]")
	public WebElement stage;
	
	@FindBy(xpath="//option[@value='Qualification']")
	public WebElement qualification_stage;
	
	@FindBy(xpath="//div[@aria-label='Date Picker']")
	public WebElement calendarIframe;
	
	@FindBy(xpath="(//input[@title='Save'])[1]")
	public WebElement save;
	
	@FindBy(id="h2.pageDescription")
	public WebElement pagedescription;
	
	@FindBy(xpath="//a[normalize-space(text())='Opportunity Pipeline']")
	public WebElement opportunityPipeline;
	
	@FindBy(xpath="//div[normalize-space(text())='Complete']")
	public WebElement completestatus;
	
	@FindBy(xpath="//a[normalize-space(text())='Stuck Opportunities']")
	public WebElement stuckOpportunity;
	
	@FindBy(id="quarter_q")
	public WebElement interval;
	
	@FindBy(xpath="//option[normalize-space(text())='Current and Next FQ']")
	public WebElement CurrentandNextFq;
	
	@FindBy(id="//select[@id='open']")
	public WebElement include;
	
	@FindBy(xpath="//option[@value='open']")
	public WebElement openopportunity;
	
	@FindBy(id="//input[@title='Run Report']")
	public WebElement runreport;
	
	
	
	
	
	
        public boolean opportunityDropdownList() throws FileNotFoundException, IOException {
	    boolean isDropdownVerified = true;

	    // Read expected values from properties file
	    String[] expectedopportunityDropdownList = FileUtils.readOpportunityPagePropertiesfile("opportunity.dropdown").split(",");
       
	    //actual values
	    Select dropdown = new Select(opportunity_dropdown);
        List<WebElement> actualopportunityDropdownList = dropdown.getOptions();

	    // Check size
	    if (expectedopportunityDropdownList.length != actualopportunityDropdownList.size()) {
	        isDropdownVerified = false;
	    }

	    // Compare each dropdown option
	    for (int i = 0; i < expectedopportunityDropdownList.length; i++) {
	        String actualOptionValue = actualopportunityDropdownList.get(i).getText().trim();
	        System.out.println("print actual values"+ actualOptionValue);
	       
			if (!actualOptionValue.equals(expectedopportunityDropdownList[i].trim())) {
	            System.out.println("Mismatch: Actual = " + actualopportunityDropdownList + ", Expected = " + expectedopportunityDropdownList[i]);
	            isDropdownVerified = false;
	        }
	    }
	    return isDropdownVerified;
	}
        
        
        
   
        
}



