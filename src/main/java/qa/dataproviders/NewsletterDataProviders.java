package qa.dataproviders;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.DataProvider;
import qa.support.modelsbuilder.ModelsBuilder;
import qa.support.constans.DataProviderNames;

public class NewsletterDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] correct() throws JsonProcessingException {

        return ModelsBuilder.getNewsletterData(DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.BLANK_USERNAME_FIELD)
    public Object[] blankUsernameField() throws JsonProcessingException {

        return ModelsBuilder.getNewsletterData(DataProviderNames.BLANK_USERNAME_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_EMAIL)
    public Object[] incorrectEmail() throws JsonProcessingException {

        return ModelsBuilder.getNewsletterData(DataProviderNames.INCORRECT_EMAIL);
    }

    @DataProvider(name = DataProviderNames.BLANK_EMAIL_FIELD)
    public Object[] blankEmailField() throws JsonProcessingException {

        return ModelsBuilder.getNewsletterData(DataProviderNames.BLANK_EMAIL_FIELD);
    }
}
