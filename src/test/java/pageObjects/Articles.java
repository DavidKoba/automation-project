package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Articles extends HeaderFooter {

	@FindBy(css = "div>.articles-page__title")
	private WebElement titleText;

	public Articles(WebDriver driver) {
		super(driver);
	}

	public String getTitleText() {
		waitForElementClickable(titleText);
		return getText(titleText);
	}

}
