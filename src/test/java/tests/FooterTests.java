package tests;

import base.BaseTest;
import org.json.JSONException;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.components.footer.Footer;
import provider.MyDataProvider;

import utils.*;

import java.io.FileNotFoundException;
import java.util.List;

public class FooterTests extends BaseTest {

    private Footer footer;

    @BeforeClass
    private void init() {

        footer = new Footer(getDriver());
    }

    @Test(priority = 3)
    public void tags() throws FileNotFoundException, JSONException {

        ExtentReportsManager.setName("Tags");
        String[] expectedURLs = JSONReader.get("URLs", "tags");

        for (int i = 0; i < footer.getTagsSection().getSize(); i++) {

            footer.getTagsSection().setTag(i);
            footer.getTagsSection().clickTagButton();

            Assert.assertEquals(expectedURLs[i], getDriver().getCurrentUrl());

            back();
        }
    }

    @Test
    public void recentPostLinks() throws JSONException {

        ExtentReportsManager.setName("Recent post links");
        String[] expectedURLs = JSONReader.get("URLs", "recentPosts");

        for (int i = 0; i < footer.getRecentPostsSection().getSize(); i++) {

            footer.getRecentPostsSection().setRecentPost(i);
            footer.getRecentPostsSection().clickRecentButton();

            Assert.assertEquals(expectedURLs[i], getDriver().getCurrentUrl());

            back();
        }
    }

    private void fillAndCheck(List<String[]> data, FuncInterface assertion) {

        for (String[] datum : data) {

            footer.getNewsletterSection().clearAll();

            footer.getNewsletterSection().setName(datum[0]);
            footer.getNewsletterSection().setEmail(datum[1]);
            footer.getNewsletterSection().clickSubscribeButton();

            assertion.run();
        }
    }

    @Test(priority = 1, dataProvider = "getBlankNameFieldNewsletterData", dataProviderClass = MyDataProvider.class)
    public void newsletterEmptyUsernameField(List<String[]> data) {

        ExtentReportsManager.setName("Empty Username field");
        fillAndCheck(data, ()->{ Assert.assertTrue(footer.getNewsletterSection().isNewsletterMessageDisplayed()); });
    }

    @Test(priority = 2, dataProvider = "getIncorrectEmailNewsletterData", dataProviderClass = MyDataProvider.class)
    public void newsletterIncorrectEmail(List<String[]> data) {

        ExtentReportsManager.setName("Incorrect Email address");
        fillAndCheck(data, ()->{ Assert.assertFalse(footer.getNewsletterSection().isNewsletterMessageDisplayed()); });
    }

}
