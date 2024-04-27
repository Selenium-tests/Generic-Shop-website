package tests.searchengine;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.PhrasesDataProviders;
import qa.support.constans.URLs;
import qa.pageobject.header.ResultsPage;
import qa.pageobject.header.SearchEngine;
import qa.support.constans.DataProviderNames;

import java.util.function.Consumer;

@Epic("E2E")
@Feature("Searching products")
public class SearchingProductsTest extends BaseTest {

    private SearchEngine searchEngine;
    private ResultsPage resultsPage;

    @BeforeMethod
    private void prepare() {

        goToPage(URLs.HOME_PAGE);
        searchEngine = new SearchEngine(getDriver());
        resultsPage = new ResultsPage(getDriver());
    }

    private void check(String phrase, Consumer<ResultsPage> consumer) throws IllegalAccessException {

        searchEngine.setPhrase(phrase);
        searchEngine.clickSubmitButton();

        consumer.accept(resultsPage);
    }

    @Test(priority = 1, dataProvider = DataProviderNames.CORRECT, dataProviderClass = PhrasesDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Search engine")
    @Tag("Buttons")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Searching with a correct phrase")
    @QaseId(6)
    @QaseTitle("Searching with a correct phrase")
    public void correct(String phrase) throws IllegalAccessException {

        Allure.parameter("Phrase", phrase);

        check(phrase, (ResultsPage rp)-> Assert.assertFalse(rp.hasNoResults(),
                "No results when searching with the \"" + phrase + "\" phrase"));
    }

    @Test(priority = 2, dataProvider = DataProviderNames.INCORRECT, dataProviderClass = PhrasesDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Buttons")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Searching with an incorrect phrase")
    @QaseId(7)
    @QaseTitle("Searching with an incorrect phrase")
    public void incorrect(String phrase) throws IllegalAccessException {

        Allure.parameter("Phrase", phrase);

        check(phrase, (ResultsPage rp)-> Assert.assertTrue(rp.hasNoResults(),
                "Results found when searching with \"" + phrase + "\" as an incorrect phrase"));
    }
}
