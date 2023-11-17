package qa.helpers;

import org.openqa.selenium.WebDriver;
import qa.pageobject.account.AccountPage;
import qa.pageobject.account.AddressColumns;

public class AddressFormPageHandler {

    public static void openAddressFormPage(WebDriver driver) {

        AccountPage accountPage = new AccountPage(driver);
        AddressColumns addressColumns = new AddressColumns(driver);

        accountPage.getAccountNavigation().clickLink("Addresses");
        addressColumns.clickBillingAddressLink();
    }
}
