package pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TripPlanned extends HeaderFooter {

	@FindBy(css = ".popular-destinations-list__item div:nth-child(2)")
	private List<WebElement> popularDestList;

	@FindBy(css = ".react-joyride__tooltip")
	private WebElement foregroundCover;

	@FindBy(css = ".sb-desktop__bar-item:nth-child(1) .step-value")
	private WebElement destText;

	@FindBy(css = ".sb-desktop__bar-item:nth-child(2) .step-value>span")
	private WebElement dateText;

	@FindBy(css = ".sb-desktop__bar-item:nth-child(3) .step-value>span")
	private WebElement numOfPassengersTextMenu;

	@FindBy(css = ".parties-input__section:nth-child(1) .parties-input__field:nth-child(1) button:nth-child(3)")
	private WebElement adult1830PlusBtn;

	@FindBy(css = ".parties-input__section:nth-child(1) .parties-input__field:nth-child(2) button:nth-child(1)")
	private WebElement adult3145MinusBtn;

	@FindBy(css = ".parties-input__section:nth-child(1) .parties-input__field:nth-child(1) .parties-input__field-value")
	private WebElement numOf1830PassengersTextBox;

	@FindBy(css = ".parties-input__section:nth-child(1) .parties-input__field:nth-child(2) .parties-input__field-value")
	private WebElement numOf3145PassengersTextBox;

	@FindBy(css = ".sb-desktop__bar-item:nth-child(5) .step-value")
	private WebElement purposeBtn;

	@FindBy(css = ".search-purpose__item>span")
	private List<WebElement> preferenceList;

	@FindBy(css = ".trip2-hero__button>.btn-dark-blue.btn")
	private WebElement saveTripBtn;

	@FindBy(css = "[title='Vacation']")
	private WebElement vacationBtn;

	@FindBy(css = ".search-interests__intensities>button:nth-child(2)")
	private WebElement intenseBtn;

	@FindBy(css = ".interests-list>li:nth-child(2) .rc-slider-handle>span")
	private WebElement sightsAndAttractionsSliderBtn;

	@FindBy(css = ".interests-list>li:nth-child(4) .rc-slider-handle>span")
	private WebElement gastronomySliderBtn;

	@FindBy(css = ".interests-list>li:nth-child(7) .rc-slider-handle>span")
	private WebElement sportsSliderBtn;

	@FindBy(css = ".btn-blue.apply-filters-button.btn")
	private WebElement showResultsBtn;

	@FindBy(css = ".toaster__title")
	private WebElement successSaveBoxText;

	@FindBy(css = ".Toastify__toast-body [rel='noreferrer noopener']")
	private WebElement bookmarksBtnBox;

	@FindBy(xpath = "//div[@class='trip-budget__loan-details-button']")
	private WebElement loanAffiliateBtn;

	@FindBy(css = ".btn-blue.btn.btn-link>span")
	private WebElement applyForFinancingBtn;

	@FindBy(css = "[for='hotel_budget']>div")
	private WebElement accomodationCheckBtn;

	@FindBy(css = ".trip-budget-modal__header>button")
	private WebElement escLoanAffiliateBtn;

	@FindBy(css = ".trip-partners__item:nth-child(1) .btn-dark-blue.btn.btn-link")
	private WebElement insuranceAffiliateBtn;

	@FindBy(css = ".trip-partners__item:nth-child(2) .btn-dark-blue.btn.btn-link")
	private WebElement carRentalAffiliateBtn;

	@FindBy(css = ".main.flex-grow-1>.trip-data-loader")
	private WebElement loadingBar;

	public TripPlanned(WebDriver driver) {
		super(driver);
	}

	public String destinationText() {
		wait.until(ExpectedConditions.visibilityOf(destText));
		return getText(destText);
	}

	public String datesText() {
		wait.until(ExpectedConditions.visibilityOf(dateText));
		return getText(dateText);
	}

	public void clearForeground() {
		wait.until(ExpectedConditions.elementToBeClickable(foregroundCover));
		Actions action = new Actions(driver);
		action.moveByOffset(5, 5);
		action.click().build().perform();
	}

	public void openingPurposeWindow() {
		wait.until(ExpectedConditions.elementToBeClickable(purposeBtn));
		click(purposeBtn);
	}

	public void choosingPreference(String text) {
		for (WebElement el : preferenceList) {
			if (el.getText().toLowerCase().contains(text)) {
				click(el);
				break;
			}
		}

	}

	public void chooseVacation() {
		hover(vacationBtn);
		click(vacationBtn);
	}

	public void selectingTripIntensity() {
		hover(intenseBtn);
		click(intenseBtn);
	}

	public void adjustingSightandAttractionsVolume(int num) {
		hover(sightsAndAttractionsSliderBtn);
		Actions action = new Actions(driver);
		int sliderVol = 1;
		while (sliderVol < num) {
			action.dragAndDropBy(sightsAndAttractionsSliderBtn, 20, 0).build().perform();
			sliderVol = Integer
					.parseInt(driver.findElement(By.cssSelector(".interests-list>li:nth-child(2) [aria-valuenow]"))
							.getAttribute("aria-valuenow"));
		}
	}

	public void adjustingGastronomyVolume(int num) {
		hover(gastronomySliderBtn);
		Actions action = new Actions(driver);
		int sliderVol = 1;
		while (sliderVol < num) {
			action.dragAndDropBy(gastronomySliderBtn, 20, 0).build().perform();
			sliderVol = Integer
					.parseInt(driver.findElement(By.cssSelector(".interests-list>li:nth-child(4) [aria-valuenow]"))
							.getAttribute("aria-valuenow"));
		}
	}

	public void adjustingSportsVolume(int num) {
		hover(sportsSliderBtn);
		Actions action = new Actions(driver);
		int sliderVol = 1;
		while (sliderVol < num) {
			action.dragAndDropBy(sportsSliderBtn, 20, 0).build().perform();
			sliderVol = Integer
					.parseInt(driver.findElement(By.cssSelector(".interests-list>li:nth-child(7) [aria-valuenow]"))
							.getAttribute("aria-valuenow"));
		}
	}

	public void clickShowResultsBtn() {
		click(showResultsBtn);
	}

	public void clickSaveTripBtn() {
		wait.until(ExpectedConditions.visibilityOf(loadingBar));
		wait.until(ExpectedConditions.invisibilityOf(loadingBar));
		hover(saveTripBtn);
		click(saveTripBtn);
	}

	public void chooseFromPopularDestinations(String text) {
		click(destText);
		for (WebElement el : popularDestList) {
			wait.until(ExpectedConditions.elementToBeClickable(el));
			if (el.getText().toLowerCase().contains(text)) {
				click(el);
				break;
			}
		}
	}

	public void clickHowManyPassengers() {
		click(numOfPassengersTextMenu);
	}

	public String getHowManyPassengers() {
		return getText(numOfPassengersTextMenu);
	}

	public void setNumOf1830Passengers(int num) {
		int numOfPas = Integer.parseInt(numOf1830PassengersTextBox.getText());
		while (numOfPas < num) {
			click(adult1830PlusBtn);
			numOfPas = Integer.parseInt(numOf1830PassengersTextBox.getText());
		}
	}

	public void setNumOf3145Passengers(int num) {
		int numOfPas = Integer.parseInt(numOf3145PassengersTextBox.getText());
		while (numOfPas > num) {
			click(adult3145MinusBtn);
			numOfPas = Integer.parseInt(numOf3145PassengersTextBox.getText());
		}
	}

	public String getSuccessSaveBoxText() {
		wait.until(ExpectedConditions.visibilityOf(successSaveBoxText));
		return getText(successSaveBoxText);
	}

	public void clickLoanAffiliateBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(loanAffiliateBtn));
		hover(loanAffiliateBtn);
		click(loanAffiliateBtn);
	}

	public void checkOnOffLoanAccomodationBtn() {
		click(accomodationCheckBtn);
		wait.until(ExpectedConditions.elementSelectionStateToBe(accomodationCheckBtn, false));
	}

	public void clickApplyForFinancingBtnAndTearDown() {
		click(applyForFinancingBtn);
		String mainWindow = driver.getWindowHandle();
		Set<String> list = driver.getWindowHandles();
		for (String win : list) {
			driver.switchTo().window(win);
		}
		wait.until(ExpectedConditions.urlContains("https://leumiservices.bankleumi.co.il/"));
		driver.close();
		driver.switchTo().window(mainWindow);
		click(escLoanAffiliateBtn);
	}

	public void clickInsuranceAffiliateBtnAndTearDown() {
		hover(insuranceAffiliateBtn);
		click(insuranceAffiliateBtn);
		String mainWindow = driver.getWindowHandle();
		Set<String> list = driver.getWindowHandles();
		for (String win : list) {
			driver.switchTo().window(win);
		}
		wait.until(ExpectedConditions.urlContains("https://www.555.co.il/pearl/apps/travel/whereStep?companyName=SHR"));
		driver.close();
		driver.switchTo().window(mainWindow);
	}

	public void clickCarRentalAffiliateBtnAndTearDown() {
		hover(carRentalAffiliateBtn);
		click(carRentalAffiliateBtn);
		String mainWindow = driver.getWindowHandle();
		Set<String> list = driver.getWindowHandles();
		for (String win : list) {
			driver.switchTo().window(win);
		}
		wait.until(
				ExpectedConditions.urlContains("https://www.rent4less.co.il/WhiteLabelsRes/7522-en/WhiteLabel.aspx"));
		driver.close();
		driver.switchTo().window(mainWindow);
	}

	public void clickMyTripsBookmarksBtn() {
		waitForElementClickable(bookmarksBtnBox);
		click(bookmarksBtnBox);
	}
}
