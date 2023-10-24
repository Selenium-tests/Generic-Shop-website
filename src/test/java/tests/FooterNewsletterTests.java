package tests;

import qa.base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.footer.Footer;
import qa.provider.MyDataProvider;
import qa.utils.Pair;

public class FooterNewsletterTests extends BaseTest {

    private Footer footer;

    @BeforeMethod
    public void create() {

        footer = new Footer(getDriver());
    }

    private void fill(Pair<String, String> data) {

        footer.getNewsletterForm().clearAll();
        footer.getNewsletterForm().setName(data.first());
        footer.getNewsletterForm().setEmail(data.second());
        footer.getNewsletterForm().clickSubscribeButton();
    }

    private void check(String expectedAlertText) {

        try {

            Alert alert = getDriver().switchTo().alert();

            Assert.assertEquals(alert.getText(), expectedAlertText);

        } catch (NoAlertPresentException e) {

            Assert.fail(e.getMessage());
        }
    }

    @Test(dataProvider = "newsletterCorrectCredentials", dataProviderClass = MyDataProvider.class)
    public void correctCredentials(Pair<String, String> data) throws InterruptedException {

        fill(data);

        Thread.sleep(2000);

        Assert.assertTrue(footer.getNewsletterForm().isMessageDisplayed());
        Assert.assertEquals(footer.getNewsletterForm().getMessageText(), "Succesfully Subscribed");
    }

    @Test(dataProvider = "newsletterBlankUsernameField", dataProviderClass = MyDataProvider.class)
    public void blankUsernameField(Pair<String, String> data) {

        fill(data);

        Assert.assertTrue(footer.getNewsletterForm().isMessageDisplayed());
    }

    @Test(dataProvider = "newsletterIncorrectEmailFormat", dataProviderClass = MyDataProvider.class)
    public void incorrectEmailFormat(Pair<String, String> data) {

        fill(data);
        check("Please enter correct email address");
    }

    @Test(dataProvider = "newsletterBlankEmailField", dataProviderClass = MyDataProvider.class)
    public void blankEmailField(Pair<String, String> data) {

        fill(data);
        check("Please enter email address");
    }
}
