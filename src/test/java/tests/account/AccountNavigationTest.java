package tests.account;

import tests.base.BaseTest;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.LinksDataProviders;
import qa.enums.URLs;
import qa.helpers.Authentication;
import qa.pageobject.account.AccountPage;
import qa.models.LinkData;
import qa.support.constans.DataProviderNames;

public class AccountNavigationTest extends BaseTest {

    private AccountPage accountPage;

    @BeforeMethod
    private void init() throws JSONException, IllegalAccessException {

        goToSpecificPage(URLs.LOGIN_PAGE.getName());
        accountPage = new AccountPage(getDriver());
        Authentication.loginWithCredentials(getDriver());
    }

    @Test(dataProvider = DataProviderNames.ACCOUNT_NAVIGATION, dataProviderClass = LinksDataProviders.class)
    public void link(LinkData linkData) throws IllegalAccessException {

        accountPage.getAccountNavigation().clickLink(linkData.getLink());

        Assert.assertEquals(getDriver().getCurrentUrl(), linkData.getUrl(),
                "The page with the address \"" + linkData.getUrl() + "\" has not been found");
    }
}