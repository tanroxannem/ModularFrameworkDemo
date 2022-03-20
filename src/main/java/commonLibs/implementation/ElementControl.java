package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * This is a wrapper methods to perform user actions writing custom methods to
 * wrap functionality provided by external libraries this helps in case the
 * implementation of the external library file changes or is deprecated.
 * 
 * @version 1.00 14 Mar 2022
 * @author Roxanne Tan
 */
public class ElementControl {

	WebDriver driver;

	public ElementControl(WebDriver driver) {
		this.driver = driver; // driver instance will get from commonDriver
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public void clear(WebElement element) {
		element.clear();
	}

	public void setText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}

	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public String getTextFromAlert() {
		return driver.switchTo().alert().getText();
	}

	/* Select value from drop down */
	public void selectViaVisibleText(WebElement element, String text) {
		Select selDropdown = new Select(element);

		selDropdown.selectByVisibleText(text);
	}
}