package testNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Destinations;

public class DestinationsNG extends BaseTest {

	@Test(description = "Making sure we are on the right page")
	public void tc01_onTheRightPage() {
		Destinations dest = new Destinations(driver);
		dest.clickLogin();
		dest.login("therealmysmarty@gmail.com", "Hardpassword");
		dest.languageSelectEnglish();
		dest.goToDestinations();
		AssertJUnit.assertTrue(dest.getTitleText().toLowerCase().contains("travel"));
	}

	@Test(description = "Checking if the input destination is shown on the page")
	public void tc02_checkingInputDestination() {
		Destinations dest = new Destinations(driver);
		AssertJUnit.assertEquals(dest.checkDestinations("geneva"), "geneva");
	}

	@Test(description = "Choosing and entering a destination")
	public void tc03_chooseDestination() {
		Destinations dest = new Destinations(driver);
		dest.goToSelectedDestination("budapest");
	}
}
