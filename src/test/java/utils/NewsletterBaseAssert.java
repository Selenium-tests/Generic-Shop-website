package utils;

import org.testng.asserts.SoftAssert;
import pages.components.NewsletterSection;

public interface NewsletterBaseAssert {

    void perform(NewsletterSection newsletterSection, SoftAssert softAssert);
}



