package qa.helpers;

import org.openqa.selenium.WebDriver;
import qa.pageobject.addressform.AddressForm;
import qa.data.AddressData;


public class AddressFormFiller {

    public static AddressForm get(AddressData data, WebDriver driver) throws IllegalAccessException {

        AddressForm addressForm = new AddressForm(driver);
        addressForm.getCountryDropdownList().setCountry(data.getCountry());
        addressForm.setFirstName(data.getFirstName());
        addressForm.setLastName(data.getLastName());
        addressForm.setCompany(data.getCompanyName());
        addressForm.setAddress_1(data.getAddress());
        addressForm.setAddress_2(data.getAddressLine2());
        addressForm.setCity(data.getCity());
        addressForm.setPostcode(data.getPostcode());
        addressForm.setPhone(data.getPhone());
        addressForm.setEmail(data.getEmail());

        return addressForm;
    }
}
