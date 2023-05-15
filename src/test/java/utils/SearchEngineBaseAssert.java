package utils;

import org.testng.asserts.SoftAssert;
import pages.components.ResultsPage;
import pages.components.SearchEngine;

public interface SearchEngineBaseAssert {

    public void perform(String phrase, ResultsPage resultsPage, SoftAssert softAssert);
}

