package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Homepage extends HeaderFooter {

	@FindBy(css = ".home-hero__button>a")
	private WebElement startPlanningBtn;

	@FindBy(css = ".home-destinations.home-content__destinations>.home-list-header .btn.btn-link")
	private WebElement viewAllDestinationsBtn;

	@FindBy(css = ".home-articles.home-content__articles>.home-list-header .btn.btn-link")
	private WebElement viewAllArticlesBtn;

	public Homepage(WebDriver driver) {
		super(driver);
	}

	public void goToStartPlanning() {
		hover(startPlanningBtn);
		click(startPlanningBtn);
	}

	public void goToAllDestinations() {
		waitForElementClickable(viewAllDestinationsBtn);
		hover(viewAllDestinationsBtn);
		click(viewAllDestinationsBtn);
	}

	public void goToViewAllArticles() {
		waitForElementClickable(viewAllArticlesBtn);
		hover(viewAllArticlesBtn);
		click(viewAllArticlesBtn);
	}
}