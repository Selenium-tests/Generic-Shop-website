package qa.dataproviders;

import org.json.JSONException;
import org.testng.annotations.DataProvider;
import qa.jsonreader.ModelsBuilder;
import qa.support.constans.DataProviderNames;

public class AddressDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] correct() throws JSONException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.BLANK_COMPANY_FIELD)
    public Object[] blankCompanyField() {

        return ModelsBuilder.getAddressFormData(DataProviderNames.BLANK_COMPANY_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_FIRST_NAME)
    public Object[] incorrectFirstName() throws JSONException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.INCORRECT_FIRST_NAME);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_LAST_NAME)
    public Object[] incorrectLastName() throws JSONException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.INCORRECT_LAST_NAME);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_POSTCODE)
    public Object[] incorrectPostcode() throws JSONException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.INCORRECT_POSTCODE);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_PHONE)
    public Object[] incorrectPhone() throws JSONException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.INCORRECT_PHONE);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_EMAIL)
    public Object[] incorrectEmail() throws JSONException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.INCORRECT_EMAIL);
    }

    @DataProvider(name = DataProviderNames.BLANK_FIRST_NAME_FIELD)
    public Object[] blankFirstNameField() {

        return ModelsBuilder.getAddressFormData(DataProviderNames.BLANK_FIRST_NAME_FIELD);
    }

    @DataProvider(name = DataProviderNames.BLANK_LAST_NAME_FIELD)
    public Object[] blankLastNameField() {

        return ModelsBuilder.getAddressFormData(DataProviderNames.BLANK_LAST_NAME_FIELD);
    }

    @DataProvider(name = DataProviderNames.BLANK_ADDRESS_FIELD)
    public Object[] blankAddressField() {

        return ModelsBuilder.getAddressFormData(DataProviderNames.BLANK_ADDRESS_FIELD);
    }

    @DataProvider(name = DataProviderNames.BLANK_ADDRESS_FIELD_LINE_2)
    public Object[] blankAddressFieldLine2() {

        return ModelsBuilder.getAddressFormData(DataProviderNames.BLANK_ADDRESS_FIELD_LINE_2);
    }

    @DataProvider(name = DataProviderNames.BLANK_CITY_FIELD)
    public Object[] blankCityField() {

        return ModelsBuilder.getAddressFormData(DataProviderNames.BLANK_CITY_FIELD);
    }

    @DataProvider(name = DataProviderNames.BLANK_POSTCODE_FIELD)
    public Object[] blankPostcodeField() {

        return ModelsBuilder.getAddressFormData(DataProviderNames.BLANK_POSTCODE_FIELD);
    }

    @DataProvider(name = DataProviderNames.BLANK_PHONE_FIELD)
    public Object[] blankPhoneField() {

        return ModelsBuilder.getAddressFormData(DataProviderNames.BLANK_PHONE_FIELD);
    }

    @DataProvider(name = DataProviderNames.BLANK_EMAIL_FIELD)
    public Object[] blankEmailField() {

        return ModelsBuilder.getAddressFormData(DataProviderNames.BLANK_EMAIL_FIELD);
    }
}
