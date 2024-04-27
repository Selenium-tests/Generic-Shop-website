package qa.support.addressformfiller;

import org.openqa.selenium.WebDriver;
import qa.pageobject.addressform.AddressForm;
import qa.models.AddressData;


public class AddressFormFiller {

    public static AddressForm get(AddressData data, WebDriver driver) throws IllegalAccessException {

        AddressForm addressForm = new AddressForm(driver);
        addressForm.getCountryDropdownList().setCountry(data.getCountry());
        addressForm
                .setFirstName(data.getFirstName())
                .setLastName(data.getLastName())
                .setCompany(data.getCompany())
                .setAddress_1(data.getAddress())
                .setAddress_2(data.getAddressLine2())
                .setCity(data.getCity())
                .setPostcode(data.getPostcode())
                .setPhone(data.getPhone())
                .setEmail(data.getEmail());

        return addressForm;
    }
}
