package tests.newsletter;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import qa.pageobject.footer.NewsletterForm;
import tests.base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.NewsletterDataProviders;
import qa.support.constans.URLs;
import qa.models.NewsletterData;
import qa.support.constans.DataProviderNames;

@Epic("E2E")
@Feature("Subscription to the newsletter")
public class SubscriptionToNewsletterTest extends BaseTest {

    private NewsletterForm newsletterForm;

    @BeforeMethod
    public void create() {

        goToPage(URLs.HOME_PAGE);
        newsletterForm = new NewsletterForm(getDriver());
    }

    private void checkMessageContent(String text) {

        try {
            newsletterForm.waitUntilMessageContentIs(text);
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

    @Test(priority = 1, dataProvider = DataProviderNames.CORRECT, dataProviderClass = NewsletterDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Footer")
    @Tag("Newsletter")
    @Tag("Fields")
    @Tag("Buttons")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(48)
    @QaseTitle("Subscribing to the newsletter using correct credentials")
    @Description("Subscribing to the newsletter using correct credentials")
    public void correct(NewsletterData newsletterData) throws IllegalAccessException {

        newsletterForm.setName(newsletterData.getUsername())
                .setEmail(newsletterData.getEmail())
                .clickSubscribeButton();

        checkMessageContent(newsletterData.getMessage());
    }

    @Test(priority = 2, dataProvider = DataProviderNames.BLANK_USERNAME_FIELD, dataProviderClass = NewsletterDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Footer")
    @Tag("Newsletter")
    @Tag("Fields")
    @Tag("Buttons")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(49)
    @QaseTitle("Subscribing to the newsletter leaving the \"Name\" field")
    @Description("Subscribing to the newsletter leaving the \"Name\" field")
    public void blankUsernameField(NewsletterData newsletterData) throws IllegalAccessException {

        newsletterForm
                .setEmail(newsletterData.getEmail())
                .clickSubscribeButton();

        checkMessageContent(newsletterData.getMessage());
    }

    @Test(priority = 3, dataProvider = DataProviderNames.INCORRECT_EMAIL, dataProviderClass = NewsletterDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Footer")
    @Tag("Newsletter")
    @Tag("Fields")
    @Tag("Buttons")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(50)
    @QaseTitle("Attempting to subscribe to the newsletter using an incorrect email format")
    @Description("Attempting to subscribe to the newsletter using an incorrect email format")
    public void incorrectEmail(NewsletterData newsletterData) throws IllegalAccessException {

        newsletterForm
                .setEmail(newsletterData.getEmail())
                .clickSubscribeButton();

        checkForAlertVisibility(newsletterData.getMessage());
    }

    @Test(priority = 4, dataProvider = DataProviderNames.BLANK_EMAIL_FIELD, dataProviderClass = NewsletterDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Footer")
    @Tag("Newsletter")
    @Tag("Fields")
    @Tag("Buttons")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(51)
    @QaseTitle("Attempting to subscribe to the newsletter without providing input for the \"Email\" field")
    @Description("Attempting to subscribe to the newsletter without providing input for the \"Email\" field")
    public void blankEmailField(NewsletterData newsletterData) {

        newsletterForm.clickSubscribeButton();
        checkForAlertVisibility(newsletterData.getMessage());
    }
}
