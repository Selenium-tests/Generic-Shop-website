package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.components.header.ResultsPage;
import pages.components.header.SearchEngine;
import provider.MyDataProvider;
import utils.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class SearchEngineTest extends BaseTest {

    private SearchEngine searchEngine;
    private ResultsPage resultsPage;

    @BeforeClass
    private void init() {

        searchEngine = new SearchEngine(getDriver());
        resultsPage = new ResultsPage(getDriver());
    }

    private void fillAndCheck(String[] data, FuncInterface assertion) throws IOException {

        for (String phrase : data) {

            searchEngine.setPhrase(phrase);
            searchEngine.clickSubmitButton();

            assertion.run();
        }
    }

    @Test(priority = 1, dataProvider = "getCorrectPhrase", dataProviderClass = MyDataProvider.class)
    public void correctPhrase(String[] data) throws IOException {

        ExtentReportsManager.setName("Searching with correct phrase");
        fillAndCheck(data, ()->{ Assert.assertFalse(resultsPage.hasNoResults()); });
    }

    @Test(priority = 2, dataProvider = "getPartOfCorrectPhrase", dataProviderClass = MyDataProvider.class)
    public void partOfCorrectPhrase(String[] data) throws IOException {

        ExtentReportsManager.setName("Searching with part of correct phrase");
        fillAndCheck(data, ()->{ Assert.assertFalse(resultsPage.hasNoResults()); });
    }

    @Test(priority = 3, dataProvider = "getUpperLower", dataProviderClass = MyDataProvider.class)
    public void upperLowerCases(String[] data) throws IOException {

        ExtentReportsManager.setName("Searching with phrase which has upper and lower cases");
        fillAndCheck(data, ()->{ Assert.assertFalse(resultsPage.hasNoResults()); });
    }

    @Test(priority = 4, dataProvider = "getIncorrectPhrase", dataProviderClass = MyDataProvider.class)
    public void incorrectPhrase(String[] data) throws IOException {

        ExtentReportsManager.setName("Searching with incorrect phrase");
        fillAndCheck(data, ()->{ Assert.assertTrue(resultsPage.hasNoResults()); });
    }

    @Test(priority = 4, dataProvider = "getSpecialSigns", dataProviderClass = MyDataProvider.class)
    public void naughtyStrings(String[] data) throws IOException {

        ExtentReportsManager.setName("Searching with naughty strings");
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(getDriver().getCurrentUrl()).openConnection();

        fillAndCheck(data, ()->{ Assert.assertEquals(httpURLConnection.getResponseCode(), 200); });
    }
}
