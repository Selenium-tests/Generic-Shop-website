package utils;

import org.testng.asserts.SoftAssert;
import pages.AccountPage;
import pages.components.CountryDropdownList;
import pages.components.NewsletterSection;

public class SoftAssertAuxTrue implements SoftAssertAux {

    @Override
    public void newsletter(NewsletterSection newsletterSection, SoftAssert softAssert) {

        softAssert.assertTrue(newsletterSection.isNewsletterMessageDisplayed());
    }

    @Override
    public void countryDropdownList(AccountPage accountPage, String countryName, SoftAssert softAssert) {

        //accountPage.getAddressForm().getCountryDropdownList().setCountry(countryName);
        softAssert.assertTrue(accountPage.getAddressForm().getCountryDropdownList().isAlertDisplayed());
        //accountPage.getAddressForm().getCountryDropdownList().clickCountryButton();
    }
}
