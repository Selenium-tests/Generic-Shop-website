package tests.searchengine;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.support.constans.URLs;
import qa.pageobject.header.SearchEngine;
import tests.base.BaseTest;

@Epic("E2E")
@Feature("Search engine")
public class InputTextVerificationTest extends BaseTest {

    private SearchEngine searchEngine;
    private final String TEXT = "This is the text!!!";

    @BeforeMethod
    private void create() {

        goToPage(URLs.HOME_PAGE);
        searchEngine = new SearchEngine(getDriver());
    }

    @Test
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Search engine")
    @Tag("Field")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(5)
    @QaseTitle("Verification of the search field text input")
    @Description("Verification of the search field text input")
    public void textInputVerification() throws IllegalAccessException {

        searchEngine.setPhrase(TEXT);
        Assert.assertEquals(searchEngine.getPhrase(), TEXT, "Incorrect output");
    }
}
