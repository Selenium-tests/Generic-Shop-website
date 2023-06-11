package utils;

import org.testng.asserts.SoftAssert;
import pages.AccountPage;
import pages.components.NewsletterSection;

public interface SoftAssertAux {

    void newsletter(NewsletterSection newsletterSection, SoftAssert softAssert);
    void countryDropdownList(AccountPage accountPage, String countryName, SoftAssert softAssert);
}



