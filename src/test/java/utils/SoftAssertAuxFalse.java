package utils;

import org.testng.asserts.SoftAssert;
import pages.AccountPage;
import pages.components.CountryDropdownList;
import pages.components.NewsletterSection;

public class SoftAssertAuxFalse implements SoftAssertAux {

    @Override
    public void newsletter(NewsletterSection newsletterSection, SoftAssert softAssert) {

        softAssert.assertFalse(newsletterSection.isNewsletterMessageDisplayed());
    }

    @Override
    public void countryDropdownList(AccountPage accountPage, String countryName, SoftAssert softAssert) {

        softAssert.assertEquals(countryName.toUpperCase(),
                                accountPage.getAddressForm().getCountryDropdownList().getCountry().toUpperCase());
        softAssert.assertFalse(accountPage.getAddressForm().getCountryDropdownList().isAlertDisplayed());
    }
}
