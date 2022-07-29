package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Destinations extends HeaderFooter {

	@FindBy(xpath = "//*[@class='destinations-header__title']")
	private WebElement titleText;

	@FindBy(css = ".form-input__input.react-autosuggest__input.destinations-header__input")
	private WebElement searchBox;

	@FindBy(xpath = "//*[@class='destinations-header__suggestion-wrapper']")
	private WebElement searchSuggestion;

	@FindBy(css = ".destinations-page-item__title.font-weight-medium")
	private List<WebElement> destList;

	public Destinations(WebDriver driver) {
		super(driver);
	}

	public String getTitleText() {
		return getText(titleText);
	}

	public void searchDestination(String text) {
		fillText(searchBox, text);
		wait.until(ExpectedConditions.elementToBeClickable(searchSuggestion));
		click(searchSuggestion);

	}

	public String checkDestinations(String text) {
		for (WebElement el : destList) {
			if (getText(el).toLowerCase().contains(text)) {
				return text;
			}
		}
		return "Nope";
	}

	public void goToSelectedDestination(String text) {
		for (WebElement el : destList) {
			if (getText(el).toLowerCase().contains(text)) {
				click(el);
				break;
			}
		}
	}
}
