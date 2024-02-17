package tests.footer;

import tests.base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.NewsletterDataProviders;
import qa.enums.URLs;
import qa.pageobject.footer.Footer;
import qa.data.NewsletterData;
import qa.support.dataprovidernames.DataProviderNames;


public class NewsletterFormTest extends BaseTest {

    private Footer footer;

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        footer = new Footer(getDriver());
    }

    private void fill(NewsletterData newsletterData) throws IllegalAccessException {

        footer.getNewsletterForm().setUsername(newsletterData.getUsername());
        footer.getNewsletterForm().setEmail(newsletterData.getEmail());
        footer.getNewsletterForm().clickSubscribeButton();
    }

    private void checkMessageContent(String text) {

        try {
            footer.getNewsletterForm().waitUntilMessageContentIs(text);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    private void checkForAlertVisibility(String expectedAlertText) {

        try {
            Alert alert = getDriver().switchTo().alert();
            Assert.assertEquals(alert.getText(), expectedAlertText, "Incorrect the alert message content");
        } catch (NoAlertPresentException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = NewsletterDataProviders.class)
    public void correct(NewsletterData newsletterData) throws IllegalAccessException {

        fill(newsletterData);
        checkMessageContent(newsletterData.getMessage());
    }

    @Test(dataProvider = DataProviderNames.BLANK_USERNAME_FIELD, dataProviderClass = NewsletterDataProviders.class)
    public void blankUsernameField(NewsletterData newsletterData) throws IllegalAccessException {

        fill(newsletterData);
        checkMessageContent(newsletterData.getMessage());
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_EMAIL, dataProviderClass = NewsletterDataProviders.class)
    public void incorrectEmail(NewsletterData newsletterData) throws IllegalAccessException {

        fill(newsletterData);
        checkForAlertVisibility(newsletterData.getMessage());
    }

    @Test(dataProvider = DataProviderNames.BLANK_EMAIL_FIELD, dataProviderClass = NewsletterDataProviders.class)
    public void blankEmailField(NewsletterData newsletterData) throws IllegalAccessException {

        fill(newsletterData);
        checkForAlertVisibility(newsletterData.getMessage());
    }
}
