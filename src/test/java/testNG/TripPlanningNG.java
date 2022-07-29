package testNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.TripPlanned;
import pageObjects.TripPlanning;

public class TripPlanningNG extends BaseTest {

	@Test(description = "Trying to plan a trip without dates")
	public void tc01_noDate() {
		Homepage hp = new Homepage(driver);
		hp.languageSelectEnglish();
		hp.goToStartPlanning();
		TripPlanning tp = new TripPlanning(driver);
		tp.chooseStartPlanning();
		tp.searchingForDestination("tokyo");
		tp.finishPlan();
		AssertJUnit.assertEquals(tp.errorMessage(), "Please, specify return date");

	}

	@Test(description = "Testing the 'previous step' button")
	public void tc02_goingBack() {
		TripPlanning tp = new TripPlanning(driver);
		tp.goingBack();
		AssertJUnit.assertEquals(tp.destinationTitleText(), "Where do you plan to go?");
	}

	@Test(description = "Planning a trip")
	public void tc03_TripPlan() {
		TripPlanning tp = new TripPlanning(driver);
		tp.searchingForDestination("tokyo");
		tp.choosingDate("july 29", "august 21");
		tp.finishPlan();
		TripPlanned tpd = new TripPlanned(driver);
		tpd.clearForeground();
		AssertJUnit.assertEquals(tpd.destinationText(), "Tokyo");
		AssertJUnit.assertEquals(tpd.datesText(), "29 Jul - 21 Aug");
	}

}
