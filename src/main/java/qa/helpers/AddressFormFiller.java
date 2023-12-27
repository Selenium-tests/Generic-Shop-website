package qa.helpers;

import org.openqa.selenium.WebDriver;
import qa.pageobject.addressform.AddressForm;
import qa.records.AddressFormData;


public class AddressFormFiller {

    public static AddressForm get(AddressFormData data, WebDriver driver) throws IllegalAccessException {

        AddressForm addressForm = new AddressForm(driver);

        addressForm.getCountryDropdownList().clickCountryButton();
        addressForm.getCountryDropdownList().setCountry(data.getCountry());
        addressForm.getCountryDropdownList().pressEnter();
        addressForm.setFirstName(data.getFirstName());
        addressForm.setLastName(data.getLastName());
        addressForm.setCompany(data.getCompanyName());
        addressForm.setAddress_1(data.getAddress1());
        addressForm.setAddress_2(data.getAddress2());
        addressForm.setCity(data.getCity());
        addressForm.setPostcode(data.getPostcode());
        addressForm.setPhone(data.getPhone());
        addressForm.setEmail(data.getEmail());

        return addressForm;
    }
}
