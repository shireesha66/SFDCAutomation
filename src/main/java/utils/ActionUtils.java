package utils;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

import tests.BaseTest;

	public class ActionUtils {

		public static void mouseHover(WebDriver driver, WebElement element) {
			Actions action = new Actions(driver);
			BaseTest.logger.debug("ActionUtils:mouseHover: ");
			action.moveToElement(element).build().perform();
		}

		public static void selectDropDownValue(WebDriver driver, WebElement dropdownElement, String value) {
			Select city = new Select(dropdownElement);
			BaseTest.logger.debug("ActionUtils:selectDropDownValue: ");
			city.selectByValue(value);
		}


}
