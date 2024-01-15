package tests.footer;

import qa.base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.pageobject.footer.Footer;
import qa.dataproviders.DataProviders;
import qa.data.Newsletter;


public class FooterNewsletterTest extends BaseTest {

    private Footer footer;

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        footer = new Footer(getDriver());
    }

    private void fill(Newsletter newsletter) throws IllegalAccessException {

        footer.getNewsletterForm().setUsername(newsletter.getUsername());
        footer.getNewsletterForm().setEmail(newsletter.getEmail());
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

    @Test(dataProvider = "newsletterCorrectCredentials", dataProviderClass = DataProviders.class)
    public void correctCredentials(Newsletter newsletter) throws IllegalAccessException {

        fill(newsletter);
        checkMessageContent(newsletter.getMessage());
    }

    @Test(dataProvider = "newsletterBlankUsernameField", dataProviderClass = DataProviders.class)
    public void blankUsernameField(Newsletter newsletter) throws IllegalAccessException {

        fill(newsletter);
        checkMessageContent(newsletter.getMessage());
    }

    @Test(dataProvider = "newsletterIncorrectEmailFormat", dataProviderClass = DataProviders.class)
    public void incorrectEmailFormat(Newsletter newsletter) throws IllegalAccessException {

        fill(newsletter);
        checkForAlertVisibility(newsletter.getAlertMessage());
    }

    @Test(dataProvider = "newsletterBlankEmailField", dataProviderClass = DataProviders.class)
    public void blankEmailField(Newsletter newsletter) throws IllegalAccessException {

        fill(newsletter);
        checkForAlertVisibility(newsletter.getAlertMessage());
    }
}
