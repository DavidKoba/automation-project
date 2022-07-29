package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	public BasePage(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//wait = new WebDriverWait(driver, 15);
	}

	public void sleep(int num) {
		try {
			Thread.sleep(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void fillText(WebElement el, String text) {
		highlightElement(el, "red");
		el.clear();
		el.sendKeys(text);
	}

	public void click(WebElement el) {
		sleep(500);
		highlightElement(el, "red");
		el.click();
		sleep(500);
	}

	public String getText(WebElement el) {
		highlightElement(el, "blue");
		return el.getText();
	}

	public void hover(WebElement el) {
		Actions actions = new Actions(driver);
		actions.moveToElement(el).build().perform();
	}

	public void waitForElementClickable(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}

	private void highlightElement(WebElement element, String color) {
		String originalStyle = element.getAttribute("style");
		String newStyle = "border: 3px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ newStyle + "');},0);", element);

		// Change the style back after few milliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},300);", element);
	}
}
