package qa.dataproviders;

import org.testng.annotations.DataProvider;
import qa.support.modelsbuilder.ModelsBuilder;
import qa.support.constans.CommonConstans;
import qa.support.constans.DataProviderNames;

public class NewsletterDataProviders {

    @DataProvider(name = DataProviderNames.NAME_FIELD_BELOW_MAX)
    public Object[] nameFieldBelowMax() {

        return ModelsBuilder.getNewsletterFieldText("nameField", CommonConstans.BELOW_MAX);
    }

    @DataProvider(name = DataProviderNames.NAME_FIELD_MAX)
    public Object[] nameFieldMax() {

        return ModelsBuilder.getNewsletterFieldText("nameField", CommonConstans.MAX);
    }

    @DataProvider(name = DataProviderNames.NAME_FIELD_ABOVE_MAX)
    public Object[] nameFieldAboveMax() {

        return ModelsBuilder.getNewsletterFieldText("nameField", CommonConstans.ABOVE_MAX);
    }

    @DataProvider(name = DataProviderNames.EMAIL_FIELD_BELOW_MAX)
    public Object[] emailFieldBelowMax() {

        return ModelsBuilder.getNewsletterFieldText("emailField", CommonConstans.BELOW_MAX);
    }

    @DataProvider(name = DataProviderNames.EMAIL_FIELD_MAX)
    public Object[] emailFieldMax() {

        return ModelsBuilder.getNewsletterFieldText("emailField", CommonConstans.MAX);
    }

    @DataProvider(name = DataProviderNames.EMAIL_FIELD_ABOVE_MAX)
    public Object[] emailFieldAboveMax() {

        return ModelsBuilder.getNewsletterFieldText("emailField", CommonConstans.ABOVE_MAX);
    }

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
