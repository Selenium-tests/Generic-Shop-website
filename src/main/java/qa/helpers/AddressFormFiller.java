package qa.helpers;

import org.openqa.selenium.WebDriver;
import qa.pageobject.addressform.AddressForm;
import qa.records.AddressFormData;


public class AddressFormFiller {

    public static AddressForm get(AddressFormData data, WebDriver driver) throws IllegalAccessException {

        AddressForm addressForm = new AddressForm(driver);

        addressForm.getCountryDropdownList().clickCountryButton();
        addressForm.getCountryDropdownList().setCountry(data.country());
        addressForm.getCountryDropdownList().pressEnter();
        addressForm.setFirstName(data.firstName());
        addressForm.setLastName(data.lastName());
        addressForm.setCompany(data.companyName());
        addressForm.setAddress_1(data.address1());
        addressForm.setAddress_2(data.address2());
        addressForm.setCity(data.city());
        addressForm.setPostcode(data.postcode());
        addressForm.setPhone(data.phone());
        addressForm.setEmail(data.email());

        return addressForm;
    }
}
