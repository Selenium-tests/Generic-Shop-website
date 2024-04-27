package qa.dataproviders;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.testng.annotations.DataProvider;
import qa.support.modelsbuilder.ModelsBuilder;
import qa.support.constans.DataProviderNames;

public class AddressDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] correct() throws JSONException, JsonProcessingException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.BLANK_COMPANY_FIELD)
    public Object[] blankCompanyField() throws JsonProcessingException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.BLANK_COMPANY_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_FIRST_NAME)
    public Object[] incorrectFirstName() throws JSONException, JsonProcessingException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.INCORRECT_FIRST_NAME);
    }

    @DataProvider(name = DataProviderNames.BLANK_FIRST_NAME_FIELD)
    public Object[] blankFirstNameField() throws JsonProcessingException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.BLANK_FIRST_NAME_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_LAST_NAME)
    public Object[] incorrectLastName() throws JSONException, JsonProcessingException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.INCORRECT_LAST_NAME);
    }

    @DataProvider(name = DataProviderNames.BLANK_LAST_NAME_FIELD)
    public Object[] blankLastNameField() throws JsonProcessingException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.BLANK_LAST_NAME_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_ADDRESS)
    public Object[] incorrectAddress() throws JsonProcessingException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.INCORRECT_ADDRESS);
    }

    @DataProvider(name = DataProviderNames.BLANK_ADDRESS_FIELD)
    public Object[] blankAddressField() throws JsonProcessingException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.BLANK_ADDRESS_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_OPTIONAL_ADDRESS)
    public Object[] incorrectOptionalAddress() throws JsonProcessingException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.INCORRECT_OPTIONAL_ADDRESS);
    }

    @DataProvider(name = DataProviderNames.BLANK_OPTIONAL_ADDRESS)
    public Object[] blankOptionalAddress() throws JsonProcessingException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.BLANK_OPTIONAL_ADDRESS);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_POSTCODE)
    public Object[] incorrectPostcode() throws JSONException, JsonProcessingException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.INCORRECT_POSTCODE);
    }

    @DataProvider(name = DataProviderNames.BLANK_POSTCODE_FIELD)
    public Object[] blankPostcodeField() throws JsonProcessingException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.BLANK_POSTCODE_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_CITY)
    public Object[] incorrectCity() throws JsonProcessingException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.INCORRECT_CITY);
    }

    @DataProvider(name = DataProviderNames.BLANK_CITY_FIELD)
    public Object[] blankCityField() throws JsonProcessingException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.BLANK_CITY_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_PHONE)
    public Object[] incorrectPhone() throws JSONException, JsonProcessingException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.INCORRECT_PHONE);
    }

    @DataProvider(name = DataProviderNames.BLANK_PHONE_FIELD)
    public Object[] blankPhoneField() throws JsonProcessingException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.BLANK_PHONE_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_EMAIL)
    public Object[] incorrectEmail() throws JSONException, JsonProcessingException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.INCORRECT_EMAIL);
    }

    @DataProvider(name = DataProviderNames.BLANK_EMAIL_FIELD)
    public Object[] blankEmailField() throws JsonProcessingException {

        return ModelsBuilder.getAddressFormData(DataProviderNames.BLANK_EMAIL_FIELD);
    }
}
