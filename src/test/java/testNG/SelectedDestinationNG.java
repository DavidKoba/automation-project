package testNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Destinations;
import pageObjects.SelectedDestination;

public class SelectedDestinationNG extends BaseTest {

	@Test(description = "Checking the functionality of the top menu buttons")
	public void tc01_topMenuButtonsFunctionality() {
		SelectedDestination sd = new SelectedDestination(driver);
		sd.clickLogin();
		sd.login("therealmysmarty@gmail.com", "Hardpassword");
		sd.languageSelectEnglish();
		sd.goToDestinations();
		Destinations dest = new Destinations(driver);
		dest.goToSelectedDestination("berlin");
		sd.goToExperiences();
		sd.goToTopPlaces();
	}

	@Test(description = "Choosing an upcoming event")
	public void tc02_chooseEventFromSlider() {
		SelectedDestination sd = new SelectedDestination(driver);
		sd.goToEvents();
		sd.filteringEventsByMusic();
		sd.goToSelectedEvent("kendrick");
		AssertJUnit.assertTrue(sd.getNewUrl().toLowerCase().contains("kendrick"));
	}
}
