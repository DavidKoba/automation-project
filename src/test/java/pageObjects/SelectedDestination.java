package pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectedDestination extends HeaderFooter {

	@FindBy(xpath = "//*[@class='destination-cta-banner__button-body']")
	private WebElement startPlanningBtn;

	@FindBy(css = ".tabs>a:nth-child(2)")
	private WebElement topPlacesBtn;

	@FindBy(css = ".tabs>a:nth-child(4)")
	private WebElement experiencesBtn;

	@FindBy(css = ".tabs>a:nth-child(5)")
	private WebElement eventsBtn;

	@FindBy(css = ".events .chips-filter__list>button:nth-child(2)")
	private WebElement musicFilterBtn;

	@FindBy(css = ".trip-slider.events__slider .trip-slider__control.trip-slider__control--next")
	private WebElement eventsSliderNextBtn;

	@FindBy(css = ".events .event-card__title")
	private List<WebElement> totalEventsList;

	public SelectedDestination(WebDriver driver) {
		super(driver);
	}

	public void goToStartPlanning() {
		click(startPlanningBtn);
	}

	public void goToTopPlaces() {
		wait.until(ExpectedConditions.elementToBeClickable(topPlacesBtn));
		hover(topPlacesBtn);
		click(topPlacesBtn);
	}

	public void goToExperiences() {
		wait.until(ExpectedConditions.elementToBeClickable(experiencesBtn));
		hover(experiencesBtn);
		click(experiencesBtn);
	}

	public void filteringEventsByMusic() {
		click(musicFilterBtn);
	}

	public void goToEvents() {
		hover(eventsBtn);
		click(eventsBtn);
	}

	public void goToSelectedEvent(String text) {
		for (WebElement el : totalEventsList) {
			if (getText(el).toLowerCase().contains(text)) {
				click(el);
				break;
			}
			while (!el.isDisplayed()) {
				click(eventsSliderNextBtn);
				if (getText(el).toLowerCase().contains(text)) {
					click(el);
					break;
				}
			}
		}
	}

	public String getNewUrl() {
		Set<String> list = driver.getWindowHandles();
		for (String win : list) {
			driver.switchTo().window(win);
		}
		return driver.getCurrentUrl();
	}
}