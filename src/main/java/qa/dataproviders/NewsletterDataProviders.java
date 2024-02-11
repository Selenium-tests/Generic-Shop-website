package qa.dataproviders;

import org.testng.annotations.DataProvider;
import qa.jsonreader.ModelsBuilder;
import qa.support.dataprovidernames.DataProviderNames;

public class NewsletterDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] correct() {

        return ModelsBuilder.getNewsletterData(DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.BLANK_USERNAME_FIELD)
    public Object[] blankUsernameField() {

        return ModelsBuilder.getNewsletterData(DataProviderNames.BLANK_USERNAME_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_EMAIL)
    public Object[] incorrectEmail() {

        return ModelsBuilder.getNewsletterData(DataProviderNames.INCORRECT_EMAIL);
    }

    @DataProvider(name = DataProviderNames.BLANK_EMAIL_FIELD)
    public Object[] blankEmailField() {

        return ModelsBuilder.getNewsletterData(DataProviderNames.BLANK_EMAIL_FIELD);
    }
}
