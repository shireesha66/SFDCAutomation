package pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.FileUtils;
import utils.WaitUtils;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="Login")
	public WebElement login;
	
	@FindBy(name="rememberUn")
	public WebElement rememberMe;
	
	@FindBy(linkText="1 Saved Username")
	public WebElement savedUsernameText;
	
	@FindBy(linkText="Forgot Your Password?")
	public WebElement forgotPassword;
	
	@FindBy(id="error")
	public WebElement errorMsg;
	
	@FindBy(id="idcard-identity")
	public WebElement savedUsername;
	
	@FindBy(id="un")
	public WebElement usernameRequest;
	

	@FindBy(id="continue")
	public WebElement continueButton;
	
	@FindBy(id="forgotPassForm")
	public WebElement forgotpasswordform;
	
	
	public void enterUsername (String username) {
		this.username.clear();
      this.username.sendKeys(username);
	}
    public void enterPassword (String password) {
		this.password.clear();
		this.password.sendKeys(password);
    }
    public void loginbutton () {
		this.login.click();
    }
    
    
    public void rememberMeCheckbox() {
    	if (this.rememberMe.isSelected()){
    		System.out.println("remember me checkbox is selected");
    	}else {
    		this.rememberMe.click();
    	}
    }
    	
    	public HomePage loginToApp( WebDriver driver,String username, String password) {
    		this.enterUsername(username);
    		this.enterPassword(password);
    		this.loginbutton();
			return new HomePage(driver);
    	}
    /*	public LoginPage performInvalidLogin( WebDriver driver,String username, String password) {
    	this.enterUsername(username);
    		this.enterPassword(password);
    		this.loginbutton();
			return this;
    	}
	*/
    	public boolean verifyLoginPage(WebDriver driver) throws FileNotFoundException, IOException {
    		String actualTitle = driver.getTitle();
    		String expectedtitle = FileUtils.readLoginPropertiesFile("page.title");
			return actualTitle.equals(expectedtitle);
    	}

    	public boolean verifyErrorMsg(WebDriver driver) throws FileNotFoundException, IOException {
    		String actualErrorMsg = driver.getTitle();
    		String expectedErrorMsg = FileUtils.readLoginPropertiesFile("error.text");
			return actualErrorMsg.equals(expectedErrorMsg);
    	}
		
      public String getSavedUsername() {
    	  return this.savedUsername.getText();
      }
	
}


