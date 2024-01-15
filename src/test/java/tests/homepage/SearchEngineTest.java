package tests.homepage;

import qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.pageobject.header.ResultsPage;
import qa.pageobject.header.SearchEngine;
import qa.dataproviders.DataProviders;

import java.util.function.Consumer;


public class SearchEngineTest extends BaseTest {

    private SearchEngine searchEngine;
    private ResultsPage resultsPage;

    @BeforeMethod
    private void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        searchEngine = new SearchEngine(getDriver());
        resultsPage = new ResultsPage(getDriver());
    }

    private void check(String phrase, Consumer<ResultsPage> consumer) throws IllegalAccessException {

        searchEngine.setPhrase(phrase);
        searchEngine.clickSubmitButton();

        consumer.accept(resultsPage);
    }

    @Test(priority = 1, dataProvider = "correctPhrase", dataProviderClass = DataProviders.class)
    public void correctPhrase(String phrase) throws IllegalAccessException {

        check(phrase, (ResultsPage rp)-> Assert.assertFalse(rp.hasNoResults(),
                "No results when searching with the \"" + phrase + "\" phrase"));
    }

    @Test(priority = 2, dataProvider = "partOfCorrectPhrase", dataProviderClass = DataProviders.class)
    public void partOfCorrectPhrase(String phrase) throws IllegalAccessException {

        check(phrase, (ResultsPage rp)-> Assert.assertFalse(rp.hasNoResults(),
                "No results when searching with the \"" + phrase + "\" phrase"));
    }

    @Test(priority = 3, dataProvider = "upperAndLowerCases", dataProviderClass = DataProviders.class)
    public void upperAndLowerCases(String phrase) throws IllegalAccessException {

        check(phrase, (ResultsPage rp)-> Assert.assertFalse(rp.hasNoResults(),
                "No results when searching with the \"" + phrase + "\" phrase"));
    }

    @Test(priority = 4, dataProvider = "incorrectPhrase", dataProviderClass = DataProviders.class)
    public void incorrectPhrase(String phrase) throws IllegalAccessException {

        check(phrase, (ResultsPage rp)-> Assert.assertTrue(rp.hasNoResults(),
                "Results found when searching with \"" + phrase + "\" as an incorrect phrase"));
    }

    @Test(priority = 4, dataProvider = "strangePhrase", dataProviderClass = DataProviders.class)
    public void strangePhrase(String phrase) throws IllegalAccessException {

        check(phrase, (ResultsPage rp)-> Assert.assertTrue(rp.hasNoResults(),
                "Results found when searching with \"" + phrase + "\" as an incorrect phrase"));
    }
}
