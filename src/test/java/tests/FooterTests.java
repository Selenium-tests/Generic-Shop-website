package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.TagPage;
import pages.components.Footer;
import provider.MyDataProvider;

import utils.SoftAssertAuxTrue;
import utils.SoftAssertAuxFalse;
import utils.SoftAssertAux;

import java.util.List;

public class FooterTests extends BaseTest {

    @Test
    public void tagsLinks() {

        Footer footer = new Footer(getDriver());
        TagPage tagPage = new TagPage(getDriver());

        for (int i = 0; i < footer.getTagsSection().getSize(); i++) {

            footer.getTagsSection().setTag(i);
            footer.getTagsSection().clickTagButton();

            getSoftAssert().assertTrue(tagPage.getPageTitle().contains(footer.getTagsSection().getName().toUpperCase()));

            back();
        }

        getSoftAssert().assertAll();
    }

    @Test
    public void recentPostLinks() {

        Footer footer = new Footer(getDriver());
        BlogPage blogPage = new BlogPage(getDriver());

        for (int i = 0; i < footer.getRecentPostsSection().getSize(); i++) {

            footer.getRecentPostsSection().setRecentPost(i);
            System.out.println(footer.getRecentPostsSection().getName());
            //footer.getRecentPostsSection().clickRecentButton();

            //back();
        }
    }

    private void helper(List<String[]> data, SoftAssertAux newsletterBaseAssert) {

        Footer footer = new Footer(getDriver());

        for (String[] datum : data) {

            footer.getNewsletterSection().clearAll();

            footer.getNewsletterSection().setName(datum[0]);
            footer.getNewsletterSection().setEmail(datum[1]);
            footer.getNewsletterSection().clickSubscribeButton();

            newsletterBaseAssert.newsletter(footer.getNewsletterSection(), getSoftAssert());
        }

        getSoftAssert().assertAll();
    }

    @Test(dataProvider = "getBlankNameFieldNewsletterData", dataProviderClass = MyDataProvider.class)
    public void newsletterBlankNameField(List<String[]> data) {

        helper(data, new SoftAssertAuxTrue());
    }

    @Test(dataProvider = "getIncorrectEmailNewsletterData", dataProviderClass = MyDataProvider.class)
    public void newsletterIncorrectEmail(List<String[]> data) {

        helper(data, new SoftAssertAuxFalse());
    }

}
