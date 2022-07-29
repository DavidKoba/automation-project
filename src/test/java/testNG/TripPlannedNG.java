package testNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.TripPlanned;
import pageObjects.TripPlanning;

public class TripPlannedNG extends BaseTest {

	@Test(description = "Changing the trip details")
	public void tc01_changeTripDetails() {
		Homepage hp = new Homepage(driver);
		hp.clickAcceptCookies();
		hp.languageSelectEnglish();
		hp.goToStartPlanning();
		TripPlanning tp = new TripPlanning(driver);
		tp.chooseStartPlanning();
		tp.searchingForDestination("tokyo");
		tp.choosingDate("july 29", "august 21");
		tp.finishPlan();
		TripPlanned tpd = new TripPlanned(driver);
		tpd.clearForeground();
		AssertJUnit.assertEquals(tpd.destinationText(), "Tokyo");
		AssertJUnit.assertEquals(tpd.datesText(), "29 Jul - 21 Aug");
		tpd.chooseFromPopularDestinations("dubai");
		AssertJUnit.assertEquals(tpd.destinationText(), "Dubai");
		tpd.clickHowManyPassengers();
		tpd.setNumOf1830Passengers(3);
		tpd.setNumOf3145Passengers(0);
		AssertJUnit.assertEquals(tpd.getHowManyPassengers(), "3 adults");
		tpd.openingPurposeWindow();
		tpd.choosingPreference("romantic");
		tpd.chooseVacation();
		tpd.selectingTripIntensity();
		tpd.adjustingSightandAttractionsVolume(5);
		tpd.adjustingGastronomyVolume(2);
		tpd.adjustingSportsVolume(10);
		tpd.clickShowResultsBtn();
	}

	@Test(description = "Saving the trip to favourites while not logged in")
	public void tc02_savePlannedTripWithoutLogin() {
		TripPlanned tpd = new TripPlanned(driver);
		tpd.clickSaveTripBtn();
		tpd.exitLogin();
	}

	@Test(description = "Making sure the Loan affiliate button works and leads to the correct URL")
	public void tc03_checkLoanAffiliteButton() {
		TripPlanned tpd = new TripPlanned(driver);
		tpd.clickLoanAffiliateBtn();
		tpd.checkOnOffLoanAccomodationBtn();
		tpd.clickApplyForFinancingBtnAndTearDown();
		tpd.clickInsuranceAffiliateBtnAndTearDown();
		tpd.clickCarRentalAffiliateBtnAndTearDown();
	}
}
