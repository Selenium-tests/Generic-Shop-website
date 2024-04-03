package tests.searchengine;

import io.qameta.allure.*;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.PhrasesDataProviders;
import qa.enums.URLs;
import qa.pageobject.header.ResultsPage;
import qa.pageobject.header.SearchEngine;
import qa.support.constans.DataProviderNames;

import java.util.function.Consumer;

@Epic("E2E")
@Feature("Search engine")
public class SearchEngineTest extends BaseTest {

    private SearchEngine searchEngine;
    private ResultsPage resultsPage;

    @BeforeMethod
    private void create() {

        goToPage(URLs.HOME_PAGE.getName());
        searchEngine = new SearchEngine(getDriver());
        resultsPage = new ResultsPage(getDriver());
    }

    private void check(String phrase, Consumer<ResultsPage> consumer) throws IllegalAccessException {

        searchEngine.setPhrase(phrase);
        searchEngine.clickSubmitButton();

        consumer.accept(resultsPage);
    }

    @Test(priority = 1, dataProvider = DataProviderNames.CORRECT, dataProviderClass = PhrasesDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(6)
    @QaseTitle("Searching with a correct phrase")
    @Description("Searching with a correct phrase")
    public void correct(String phrase) throws IllegalAccessException {

        check(phrase, (ResultsPage rp)-> Assert.assertFalse(rp.hasNoResults(),
                "No results when searching with the \"" + phrase + "\" phrase"));
    }

    @Test(priority = 2, dataProvider = DataProviderNames.INCORRECT, dataProviderClass = PhrasesDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(7)
    @QaseTitle("Searching with an incorrect phrase")
    @Description("Searching with an incorrect phrase")
    public void incorrect(String phrase) throws IllegalAccessException {

        check(phrase, (ResultsPage rp)-> Assert.assertTrue(rp.hasNoResults(),
                "Results found when searching with \"" + phrase + "\" as an incorrect phrase"));
    }
}
