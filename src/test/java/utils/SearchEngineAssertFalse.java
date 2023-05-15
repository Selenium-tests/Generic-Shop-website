package utils;

import org.testng.asserts.SoftAssert;
import pages.components.ResultsPage;
import pages.components.SearchEngine;

public class SearchEngineAssertFalse implements SearchEngineBaseAssert {

    public void perform(String phrase, ResultsPage resultsPage, SoftAssert softAssert) {

        softAssert.assertTrue(resultsPage.hasNoResults());
    }

}
