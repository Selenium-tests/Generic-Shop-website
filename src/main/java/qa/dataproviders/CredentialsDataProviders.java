package qa.dataproviders;

import org.json.JSONException;
import org.testng.annotations.DataProvider;
import qa.jsonreader.ModelsBuilder;
import qa.support.dataprovidernames.DataProviderNames;

public class CredentialsDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] correct() throws JSONException {

        return ModelsBuilder.getCredentials(DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_USERNAME)
    public Object[] incorrectUsername() throws JSONException {

        return ModelsBuilder.getCredentials(DataProviderNames.INCORRECT_USERNAME);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_PASSWORD)
    public Object[] incorrectPassword() throws JSONException {

        return ModelsBuilder.getCredentials(DataProviderNames.INCORRECT_PASSWORD);
    }

    @DataProvider(name = DataProviderNames.BLANK_USERNAME_FIELD)
    public Object[] blankUsernameField() {

        return ModelsBuilder.getCredentials(DataProviderNames.BLANK_USERNAME_FIELD);
    }

    @DataProvider(name = DataProviderNames.BLANK_PASSWORD_FIELD)
    public Object[] blankPasswordField() {

        return ModelsBuilder.getCredentials(DataProviderNames.BLANK_PASSWORD_FIELD);
    }
}
