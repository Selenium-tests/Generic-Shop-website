package utils;

import org.testng.asserts.SoftAssert;
import pages.components.NewsletterSection;

public class NewsletterAssertFalse implements NewsletterBaseAssert {

    public void perform(NewsletterSection newsletterSection, SoftAssert softAssert) {

        softAssert.assertFalse(newsletterSection.isNewsletterMessageDisplayed());
    }
}
