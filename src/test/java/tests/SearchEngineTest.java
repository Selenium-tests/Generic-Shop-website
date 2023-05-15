package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.components.ResultsPage;
import pages.components.SearchEngine;
import provider.MyDataProvider;
import utils.SearchEngineAssertFalse;
import utils.SearchEngineAssertTrue;
import utils.SearchEngineBaseAssert;

import java.util.List;

public class SearchEngineTest extends BaseTest {

    private void helper(List<String[]> data, SearchEngineBaseAssert searchEngineBaseAssert) throws InterruptedException {

        SearchEngine searchEngine = new SearchEngine(getDriver());
        ResultsPage resultsPage = new ResultsPage(getDriver());

        for (String[] phrases : data) {

            for (String phrase : phrases) {

                searchEngine.setPhrase(phrase);
                searchEngine.clickSubmitButton();

                searchEngineBaseAssert.perform(phrase, resultsPage, getSoftAssert());

            }
        }

        getSoftAssert().assertAll();
    }

    @Test(dataProvider = "getCorrectPhrase", dataProviderClass = MyDataProvider.class)
    public void correctPhrase(List<String[]> data) throws InterruptedException {

        helper(data, new SearchEngineAssertTrue());
    }

    @Test(dataProvider = "getPartOfCorrectPhrase", dataProviderClass = MyDataProvider.class)
    public void partOfCorrectPhrase(List<String[]> data) throws InterruptedException {

        helper(data, new SearchEngineAssertTrue());
    }

    @Test(dataProvider = "getUpperLower", dataProviderClass = MyDataProvider.class)
    public void upperLowerCases(List<String[]> data) throws InterruptedException {

        helper(data, new SearchEngineAssertTrue());
    }

    @Test(dataProvider = "getIncorrectPhrase", dataProviderClass = MyDataProvider.class)
    public void incorrectPhrase(List<String[]> data) throws InterruptedException {

        helper(data, new SearchEngineAssertFalse());
    }

    @Test(dataProvider = "getSpecialSigns", dataProviderClass = MyDataProvider.class)
    public void specialSigns(List<String[]> data) throws InterruptedException {

        helper(data, new SearchEngineAssertFalse());
    }
}
