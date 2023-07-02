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
import java.io.IOException;
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

    private void fillAndCheck(List<Pair<String, String>> data, FuncInterface assertion) throws IOException {

        for (Pair<String, String> datum : data) {

            footer.getNewsletterSection().clearAll();

            footer.getNewsletterSection().setName(datum.first());
            footer.getNewsletterSection().setEmail(datum.second());
            footer.getNewsletterSection().clickSubscribeButton();

            assertion.run();
        }
    }

    @Test(priority = 1, dataProvider = "getBlankNameFieldNewsletterData", dataProviderClass = MyDataProvider.class)
    public void newsletterEmptyUsernameField(List<Pair<String, String>> data) throws IOException {

        ExtentReportsManager.setName("Empty Username field");
        fillAndCheck(data, ()->{ Assert.assertTrue(footer.getNewsletterSection().isNewsletterMessageDisplayed()); });
    }

    @Test(priority = 2, dataProvider = "getIncorrectEmailNewsletterData", dataProviderClass = MyDataProvider.class)
    public void newsletterIncorrectEmail(List<Pair<String, String>> data) throws IOException {

        ExtentReportsManager.setName("Incorrect Email address");
        fillAndCheck(data, ()->{ Assert.assertFalse(footer.getNewsletterSection().isNewsletterMessageDisplayed()); });
    }

}
