package qa.dataproviders;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.testng.annotations.DataProvider;
import qa.support.modelsbuilder.ModelsBuilder;
import qa.support.constans.DataProviderNames;

public class CredentialsDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] correct() throws JSONException, JsonProcessingException {

        return ModelsBuilder.getCredentials(DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_USERNAME)
    public Object[] incorrectUsername() throws JSONException, JsonProcessingException {

        return ModelsBuilder.getCredentials(DataProviderNames.INCORRECT_USERNAME);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_PASSWORD)
    public Object[] incorrectPassword() throws JSONException, JsonProcessingException {

        return ModelsBuilder.getCredentials(DataProviderNames.INCORRECT_PASSWORD);
    }

    @DataProvider(name = DataProviderNames.BLANK_USERNAME_FIELD)
    public Object[] blankUsernameField() throws JsonProcessingException {

        return ModelsBuilder.getCredentials(DataProviderNames.BLANK_USERNAME_FIELD);
    }

    @DataProvider(name = DataProviderNames.BLANK_PASSWORD_FIELD)
    public Object[] blankPasswordField() throws JsonProcessingException {

        return ModelsBuilder.getCredentials(DataProviderNames.BLANK_PASSWORD_FIELD);
    }
}
