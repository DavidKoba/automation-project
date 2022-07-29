package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderFooter extends BasePage {

	@FindBy(css = "a>.app-header__logo")
	private WebElement logoHomepageBtn;

	@FindBy(css = ".cookies-policy-banner>button")
	private WebElement acceptCookiesBtn;

	@FindBy(css = ".nav-right__toggle>.btn[dir='ltr']")
	private WebElement rightMenuBtn;
	@FindBy(css = ".locale-settings-list>button:nth-child(1)")
	private WebElement hebBtn;

	@FindBy(css = ".nav-right__toggle>.btn[dir='rtl']")
	private WebElement leftMenuBtn;
	@FindBy(xpath = "//*[@class='locale-settings-list__item']")
	private WebElement engBtn;

	@FindBy(css = ".container.container--large>h1")
	private WebElement titleText;

	@FindBy(xpath = "//*[@class=\"footer__bottom\"]")
	private WebElement footerText;

	@FindBy(xpath = "//*[@class='btn-dark-blue btn']")
	private WebElement loginBtn;
	@FindBy(css = ".modal-v2__close-button")
	private WebElement escLoginBox;
	@FindBy(css = "#email")
	private WebElement emailField;
	@FindBy(css = "div>#password")
	private WebElement pwField;
	@FindBy(xpath = "//*[@data-testid='submit-button']")
	private WebElement submitBtn;
	@FindBy(css = ".form-error")
	private WebElement loginErrorMsg;

	@FindBy(css = ".nav-right__user-profile>button")
	private WebElement loggedUserName;

	@FindBy(css = ".app-header__desktop .header-nav__list>a:nth-child(1)")
	private WebElement destBtn;

	@FindBy(css = ".app-header__desktop .header-nav__item:nth-child(2)")
	private WebElement myTripsBtn;

	public HeaderFooter(WebDriver driver) {
		super(driver);
	}

	public void languageSelectEnglish() {
		waitForElementClickable(leftMenuBtn);
		hover(leftMenuBtn);
		waitForElementClickable(engBtn);
		click(engBtn);
	}

	public void languageSelectHebrew() {
		waitForElementClickable(rightMenuBtn);
		hover(rightMenuBtn);
		waitForElementClickable(hebBtn);
		click(hebBtn);
	}

	public String titleText() {
		waitForElementClickable(titleText);
		hover(titleText);
		return getText(titleText);
	}

	public String footerText() {
		hover(footerText);
		return getText(footerText);
	}

	public void clickLogin() {
		click(loginBtn);
	}

	public void login(String username, String password) {
		fillText(emailField, username);
		fillText(pwField, password);
		click(submitBtn);
	}

	public void exitLogin() {
		click(escLoginBox);
	}

	public void goToDestinations() {
		click(destBtn);
	}

	public void goToMyTrips() {
		click(myTripsBtn);
	}

	public void goToHomepage() {
		click(logoHomepageBtn);
	}

	public void clickAcceptCookies() {
		waitForElementClickable(acceptCookiesBtn);
		hover(acceptCookiesBtn);
		click(acceptCookiesBtn);
	}

	public String getErrorMessage() {
		return getText(loginErrorMsg);
	}

	public String getLoggedUsername() {
		waitForElementClickable(loggedUserName);
		return getText(loggedUserName);
	}
}