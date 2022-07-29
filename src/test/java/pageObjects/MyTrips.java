package pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyTrips extends HeaderFooter {

	@FindBy(css = ".tabs>a:nth-child(1)")
	private WebElement myTripsListBtn;

	@FindBy(css = ".tabs>a:nth-child(2)")
	private WebElement myRoutesListBtn;

	@FindBy(css = ".tabs>a:nth-child(3)")
	private WebElement myPoisListBtn;

	@FindBy(css = ".empty-state__container>h3")
	private WebElement emptyListText;

	@FindBy(css = ".bookmarks-trips-list__empty-state-button>a")
	private WebElement createATripBtn;

	@FindBy(css = ".bookmarks-trips-list>.trip-item")
	private List<WebElement> bookmarkedTrips;

	@FindBy(css = ".trip-item__control.trip-item__control--delete")
	private WebElement deleteTripBtn;

	@FindBy(css = ".btn-blue.btn-small.btn")
	private WebElement confirmRemoveBtn;

	public MyTrips(WebDriver driver) {
		super(driver);
	}

	public void clickMyTripsListBtn() {
		click(myTripsListBtn);
	}

	public void clickmyRoutesListBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(myRoutesListBtn));
		click(myRoutesListBtn);
	}

	public void clickMyPoisListBtn() {
		click(myPoisListBtn);
	}

	public String getTextEmptyListText() {
		waitForElementClickable(emptyListText);
		return getText(emptyListText);
	}

	public void clickCreateATripBtn() {
		waitForElementClickable(createATripBtn);
		click(createATripBtn);
	}

	public int getNumberOfTrips() {
		return bookmarkedTrips.size();
	}

	public void deleteAllTrips() {
		String mainWindow = driver.getWindowHandle();
		Set<String> list = driver.getWindowHandles();
		for (String win : list) {
			driver.switchTo().window(win);
		}
		for (WebElement el : bookmarkedTrips) {
			if (getNumberOfTrips() > 0) {
				waitForElementClickable(el);
				click(deleteTripBtn);
				click(confirmRemoveBtn);
			}
		}
		driver.close();
		driver.switchTo().window(mainWindow);
	}
}