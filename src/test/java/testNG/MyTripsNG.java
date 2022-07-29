package testNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MyTrips;
import pageObjects.TripPlanned;
import pageObjects.TripPlanning;

public class MyTripsNG extends BaseTest {

	@Test(description = "Checking the functionality of the menu tabs")
	public void tc01_functionalityOfMenuButtons() {
		MyTrips mt = new MyTrips(driver);
		mt.languageSelectEnglish();
		mt.goToMyTrips();
		mt.login("therealmysmarty@gmail.com", "Hardpassword");
		mt.clickmyRoutesListBtn();
		AssertJUnit.assertEquals(mt.getTextEmptyListText(), "It is empty here");
		mt.clickMyPoisListBtn();
		AssertJUnit.assertEquals(mt.getTextEmptyListText(), "It is empty here");
		mt.clickMyTripsListBtn();
		AssertJUnit.assertEquals(mt.getTextEmptyListText(), "It is empty here");
	}

	@Test(description = "Creating a trip")
	public void tc02_createATrip() {
		MyTrips mt = new MyTrips(driver);
		mt.clickCreateATripBtn();
		TripPlanning tp = new TripPlanning(driver);
		tp.chooseStartPlanning();
		tp.searchingForDestination("tokyo");
		tp.choosingDate("july 30", "august 21");
		tp.finishPlan();
		TripPlanned tpd = new TripPlanned(driver);
		tpd.clearForeground();
		AssertJUnit.assertEquals(tpd.destinationText(), "Tokyo");
		AssertJUnit.assertEquals(tpd.datesText(), "30 Jul - 21 Aug");
		tpd.clickSaveTripBtn();
		tpd.clickMyTripsBookmarksBtn();
		mt.deleteAllTrips();

	}
}
