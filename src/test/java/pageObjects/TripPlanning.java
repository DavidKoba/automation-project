package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TripPlanning extends HeaderFooter {

	@FindBy(css = "div>.create-trip__title")
	private WebElement titleText;

	@FindBy(css = ".flows>div:nth-child(1)")
	private WebElement startPlanningBtn;

	@FindBy(css = ".flows>div:nth-child(2)")
	private WebElement inspireMeBtn;

	@FindBy(css = ".rs-select2__input input")
	private WebElement searchBox;

	@FindBy(css = ".btn-blue.btn")
	private WebElement nextStepBtn;

	@FindBy(css = ".create-trip__body-container>.create-trip__title")
	private WebElement destinationTitleText;

	@FindBy(xpath = "//*[@class='create-trip-back']")
	private WebElement backBtn;;

	@FindBy(xpath = "//*[@class='destination-form__list-item']")
	private List<WebElement> popDestinations;

	@FindBy(css = ".destination-form-place-option")
	private WebElement offeredDest;

	@FindBy(css = ".Toastify__toast-body")
	private WebElement errorText;

	@FindBy(xpath = "//span[@class='flatpickr-day ']")
	private List<WebElement> daysDeparture;
	@FindBy(xpath = "//span[@class='flatpickr-day']")
	private List<WebElement> daysReturn;

	@FindBy(css = ".dates-form__submit>.btn-blue.btn")
	private WebElement planATripBtn;

	public TripPlanning(WebDriver driver) {
		super(driver);
	}

	public void chooseStartPlanning() {
		wait.until(ExpectedConditions.elementToBeClickable(startPlanningBtn));
		click(startPlanningBtn);
	}

	public void searchingForDestination(String text) {
		fillText(searchBox, text);
		waitForElementClickable(offeredDest);
		click(offeredDest);
		click(nextStepBtn);
	}

	public void choosingDate(String departureDate, String returnDate) {
		for (WebElement el : daysDeparture) {
			if (el.getAttribute("aria-label").toLowerCase().contains(departureDate)) {
				click(el);
				break;
			}
		}
		for (WebElement el : daysReturn) {
			if (el.getAttribute("aria-label").toLowerCase().contains(returnDate)) {
				click(el);
				break;
			}
		}
	}

	public void finishPlan() {
		click(planATripBtn);
	}

	public String errorMessage() {
		return getText(errorText);
	}

	public void goingBack() {
		click(backBtn);
	}

	public String destinationTitleText() {
		return getText(destinationTitleText);
	}

	public String getTitleText() {
		waitForElementClickable(titleText);
		return getText(titleText);
	}
}
