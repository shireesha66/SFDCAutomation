package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;

public class FileUtils {
	public static String readLoginPropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants.LOGIN_TEST_DATA_FILE));
		return p.getProperty(key);
		
	}
	
	public static String readHomePagePropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants.HOME_TEST_DATA_FILE));
		return p.getProperty(key);
		
	}

	public static String readusermenupropertiesfile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants.USERMENU_TEST_DATA_FILE));
		return p.getProperty(key);
	}
	public static String readfiletoupload(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants.TEST_FILE_UPLOAD_PATH));
		return p.getProperty(key);
	}
	
	public static String CreateAccountPagePropertiesfile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants.CREATENEWACCOUNT_TEST_DATA_FILE));
		return p.getProperty(key);

}
	
	public static String readOpportunityPagePropertiesfile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants.OPPORTUNITY_TEST_DATA_FILE));
		return p.getProperty(key);

}
	public static String readLeadPagePropertiesfile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants.LEAD_TEST_DATA_FILE));
		return p.getProperty(key);
		
	}

	public static String readContactsPagePropertiesfile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants.CONTACTS_TEST_DATA_FILE));
		return p.getProperty(key);
		
	}
	

	
}
