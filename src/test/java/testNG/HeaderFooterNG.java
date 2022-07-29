package testNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HeaderFooter;

public class HeaderFooterNG extends BaseTest {

	@Test(description = "Appearance of the login window")
	public void clickLogin() {
		HeaderFooter hf = new HeaderFooter(driver);
		hf.clickLogin();
	}
//	@Test(dataProvider = "getData", description = "Multiple unsuccessful login attempts")
//	public void tc01_UnsuccessfulLogin(String username, String password) {
//		HeaderFooter hf = new HeaderFooter(driver);
//		hf.login(username, password);
//		Assert.assertEquals(hf.getErrorMessage(), "לא ניתן להתחבר עם פרטי המשתמש שהוזנו");
//
//	}
//
//	@DataProvider
//	public Object[][] getData() {
//		Object[][] myData = { 
//				{ "aaa@dada.ca", "123121" },
//				{ "tre@trea.wa", "Hardpassword" },
//				{ "therealmysmarty@gmail.com", "32323redw" },
//				};
//		return myData;
//	}

	@Test(description = "Successfully logging in")
	public void tc02_login() {
		HeaderFooter hf = new HeaderFooter(driver);
		hf.login("therealmysmarty@gmail.com", "Hardpassword");
		AssertJUnit.assertEquals(hf.getLoggedUsername(), "היי, Tester");
	}

	@Test(description = "Changing language to English")
	public void tc03_changeLanguageToEnglish() {
		HeaderFooter hf = new HeaderFooter(driver);
		hf.languageSelectEnglish();
		AssertJUnit.assertTrue(hf.titleText().toLowerCase().contains("trip"));
	}

	@Test(description = "Making sure footer text is visible properly")
	public void tc04_getFooterText() {
		HeaderFooter hf = new HeaderFooter(driver);
		AssertJUnit.assertEquals(hf.footerText(), "© 2022 Shichor");
	}

	@Test(description = "Changing language to Hebrew")
	public void tc05_changeLanguageToHebrew() {
		HeaderFooter hf = new HeaderFooter(driver);
		hf.languageSelectHebrew();
		AssertJUnit.assertTrue(hf.titleText().contains("טיול"));
	}
}