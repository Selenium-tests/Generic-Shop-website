package tests.homepage;

import qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.PhrasesDataProviders;
import qa.enums.URLs;
import qa.pageobject.header.ResultsPage;
import qa.pageobject.header.SearchEngine;
import qa.support.dataprovidernames.DataProviderNames;

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

    @Test(priority = 1, dataProvider = DataProviderNames.CORRECT, dataProviderClass = PhrasesDataProviders.class)
    public void correct(String phrase) throws IllegalAccessException {

        check(phrase, (ResultsPage rp)-> Assert.assertFalse(rp.hasNoResults(),
                "No results when searching with the \"" + phrase + "\" phrase"));
    }

    @Test(priority = 2, dataProvider = DataProviderNames.PARTIAL, dataProviderClass = PhrasesDataProviders.class)
    public void partial(String phrase) throws IllegalAccessException {

        check(phrase, (ResultsPage rp)-> Assert.assertFalse(rp.hasNoResults(),
                "No results when searching with the \"" + phrase + "\" phrase"));
    }

    @Test(priority = 3, dataProvider = DataProviderNames.INCORRECT, dataProviderClass = PhrasesDataProviders.class)
    public void incorrect(String phrase) throws IllegalAccessException {

        check(phrase, (ResultsPage rp)-> Assert.assertTrue(rp.hasNoResults(),
                "Results found when searching with \"" + phrase + "\" as an incorrect phrase"));
    }

    @Test(priority = 4, dataProvider = DataProviderNames.NAUGHTY_STRINGS, dataProviderClass = PhrasesDataProviders.class)
    public void naughtyStrings(String phrase) throws IllegalAccessException {

        check(phrase, (ResultsPage rp)-> Assert.assertTrue(rp.hasNoResults(),
                "Results found when searching with \"" + phrase + "\" as an incorrect phrase"));
    }
}
