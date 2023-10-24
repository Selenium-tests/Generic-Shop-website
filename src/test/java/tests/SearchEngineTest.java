package tests;

import qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.header.ResultsPage;
import qa.pageobject.header.SearchEngine;
import qa.provider.MyDataProvider;
import java.util.function.Consumer;


public class SearchEngineTest extends BaseTest {

    private SearchEngine searchEngine;
    private ResultsPage resultsPage;

    @BeforeMethod
    private void create() {

        searchEngine = new SearchEngine(getDriver());
        resultsPage = new ResultsPage(getDriver());
    }

    private void check(String phrase, Consumer<ResultsPage> consumer) {

        searchEngine.setPhrase(phrase);
        searchEngine.clickSubmitButton();

        consumer.accept(resultsPage);
    }

    @Test(priority = 1, dataProvider = "correctPhrase", dataProviderClass = MyDataProvider.class)
    public void correctPhrase(String phrase) {

        //ExtentReportsManager.setName("Searching with correct phrase");

        check(phrase, (ResultsPage rp)-> Assert.assertFalse(rp.hasNoResults()));
    }

    @Test(priority = 2, dataProvider = "partOfCorrectPhrase", dataProviderClass = MyDataProvider.class)
    public void partOfCorrectPhrase(String phrase) {

        //ExtentReportsManager.setName("Searching with part of correct phrase");

        check(phrase, (ResultsPage rp)-> Assert.assertFalse(rp.hasNoResults()));
    }

    @Test(priority = 3, dataProvider = "upperAndLowerCases", dataProviderClass = MyDataProvider.class)
    public void upperAndLowerCases(String phrase) {

        //ExtentReportsManager.setName("Searching with phrase which has upper and lower cases");

        check(phrase, (ResultsPage rp)-> Assert.assertFalse(rp.hasNoResults()));
    }

    @Test(priority = 4, dataProvider = "incorrectPhrase", dataProviderClass = MyDataProvider.class)
    public void incorrectPhrase(String phrase) {

        //ExtentReportsManager.setName("Searching with incorrect phrase");

        check(phrase, (ResultsPage rp)-> Assert.assertTrue(rp.hasNoResults()));
    }

    @Test(priority = 4, dataProvider = "strangePhrase", dataProviderClass = MyDataProvider.class)
    public void strangePhrase(String phrase) {

        //ExtentReportsManager.setName("Searching with strange phrase");

        check(phrase, (ResultsPage rp)-> Assert.assertTrue(rp.hasNoResults()));
    }
}
