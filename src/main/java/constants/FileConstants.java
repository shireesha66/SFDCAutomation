package constants;

//import java.io.File;

//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;

import utils.CommonUtils;

public class FileConstants {
	public static final String ROOT_PATH =System.getProperty("user.dir");
	public static final String LOGIN_TEST_DATA_FILE = ROOT_PATH +"/src/main/java/testData/login.properties";
	public static final String HOME_TEST_DATA_FILE = ROOT_PATH +"/src/main/java/testData/homepage.properties";
	public static final String USERMENU_TEST_DATA_FILE = ROOT_PATH +"/src/main/java/testData/homepage/usermenu.properties";
	public static final String SCREENSHOT_PATH = ROOT_PATH+ "/src/main/resources/reports/"+ CommonUtils.getTimestamp()+".PNG";
	public static final String TEST_FILE_UPLOAD_PATH = "C:/Users/mahen/Desktop/flower.jpg/";
	public static final String REPORT_PATH = ROOT_PATH + "/src/main/resources/reports/" + CommonUtils.getTimestamp()
	+ ".html";
	public static final String CREATENEWACCOUNT_TEST_DATA_FILE =  ROOT_PATH +"/src/main/java/testData/CreateNewAccount.properties";
	public static final String OPPORTUNITY_TEST_DATA_FILE =  ROOT_PATH +"/src/main/java/testData/Opportunity.properties";
	public static final String LEAD_TEST_DATA_FILE = ROOT_PATH +"/src/main/java/testData/Leads.properties";
	public static final String CONTACTS_TEST_DATA_FILE = ROOT_PATH +"/src/main/java/testData/contact.properties";

}



