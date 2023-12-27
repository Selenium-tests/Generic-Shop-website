package tests.footer;

import qa.base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.pageobject.footer.Footer;
import qa.provider.MyDataProvider;
import qa.extentreports.ExtentReportsManager;
import qa.records.Newsletter;


public class FooterNewsletterTests extends BaseTest {

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

    private void check(String expectedAlertText, String message) {

        try {

            Alert alert = getDriver().switchTo().alert();
            Assert.assertEquals(alert.getText(), expectedAlertText, message);

        } catch (NoAlertPresentException e) {

            Assert.fail(e.getMessage());
        }
    }

    @Test(dataProvider = "newsletterCorrectCredentials", dataProviderClass = MyDataProvider.class)
    public void correctCredentials(Newsletter newsletter) throws InterruptedException, IllegalAccessException {

        ExtentReportsManager.setName("Signing up for the newsletter with correct credentials.");

        fill(newsletter);

        Thread.sleep(1000);

        Assert.assertTrue(footer.getNewsletterForm().isMessageDisplayed(),
               "No message when signing up with correct credentials");
        Assert.assertEquals(footer.getNewsletterForm().getMessageText(), "Successfully Subscribed.",
                "Incorrect message text when signing up with correct credentials");
    }

    @Test(dataProvider = "newsletterBlankUsernameField", dataProviderClass = MyDataProvider.class)
    public void blankUsernameField(Newsletter newsletter) throws IllegalAccessException {

        ExtentReportsManager.setName("Signing up for the newsletter with the blank username field.");

        fill(newsletter);

        Assert.assertTrue(footer.getNewsletterForm().isMessageDisplayed(),
                "No signing up with the blank username field");
    }

    @Test(dataProvider = "newsletterIncorrectEmailFormat", dataProviderClass = MyDataProvider.class)
    public void incorrectEmailFormat(Newsletter newsletter) throws IllegalAccessException {

        ExtentReportsManager.setName("Signing up for the newsletter with an incorrect email format.");

        fill(newsletter);

        check("Please enter correct email address",
              "Incorrect message text during signing up with an incorrect email format");
    }

    @Test(dataProvider = "newsletterBlankEmailField", dataProviderClass = MyDataProvider.class)
    public void blankEmailField(Newsletter newsletter) throws IllegalAccessException {

        ExtentReportsManager.setName("Signing up for the newsletter with the blank email field.");

        fill(newsletter);

        check("Please enter email address",
              "Incorrect message text during signing up with the blank email field");
    }
}
