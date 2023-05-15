package utils;

import org.testng.asserts.SoftAssert;
import pages.components.NewsletterSection;

public class NewsletterAssertTrue implements NewsletterBaseAssert {

    public void perform(NewsletterSection newsletterSection, SoftAssert softAssert) {

        softAssert.assertTrue(newsletterSection.isNewsletterMessageDisplayed());
    }
}
