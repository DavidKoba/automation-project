package testNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Articles;
import pageObjects.Destinations;
import pageObjects.Homepage;
import pageObjects.TripPlanning;

public class HomepageNG extends BaseTest {

	@Test(description = "Checking the functionality of the homepage buttons")
	public void tc01_FunctionalityOfButtons() {
		Homepage hp = new Homepage(driver);
		hp.languageSelectEnglish();
		
		hp.goToAllDestinations();
		Destinations dest = new Destinations(driver);
		AssertJUnit.assertEquals(dest.getTitleText(), "Travel anywhere");
		
		hp.goToHomepage();
		hp.goToViewAllArticles();
		Articles articles = new Articles(driver);
		AssertJUnit.assertEquals(articles.getTitleText(), "Articles");
		
		hp.goToHomepage();
		hp.goToStartPlanning();
		TripPlanning tp = new TripPlanning(driver);
		AssertJUnit.assertEquals(tp.getTitleText(), "So, what’s next?");
	}
}
