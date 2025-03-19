package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RandomScenariosPage extends BasePage {

	public RandomScenariosPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath=" //h1[@class='currentStatusUserName']//a[1]")
	public WebElement currentUserName;
	
	
	
	@FindBy(xpath="//a[@title='Home Tab - Selected']")
	public WebElement HomeTab;

}
