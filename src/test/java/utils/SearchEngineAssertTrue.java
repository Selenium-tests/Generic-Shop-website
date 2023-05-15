package utils;

import org.testng.asserts.SoftAssert;
import pages.components.ResultsPage;
import pages.components.SearchEngine;

public class SearchEngineAssertTrue implements SearchEngineBaseAssert {

    public void perform(String phrase, ResultsPage resultsPage, SoftAssert softAssert) {

        for (int i = 0; i < resultsPage.resultsSize(); i++) {

            softAssert.assertTrue(resultsPage.getResult(i).toUpperCase()
                    .contains(phrase.toUpperCase()));
        }
    }
}
