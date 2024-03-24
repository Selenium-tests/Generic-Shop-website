package tests.newsletter;

import io.qameta.allure.*;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.NewsletterDataProviders;
import qa.enums.URLs;
import qa.pageobject.footer.NewsletterForm;
import qa.support.constans.DataProviderNames;
import tests.base.BaseTest;

@Epic("E2E")
@Feature("Validation of user input")
public class MaxLengthTest extends BaseTest {

    private NewsletterForm newsletterForm;

    @BeforeMethod
    public void create() {

        goToPage(URLs.HOME_PAGE.getName());
        newsletterForm = new NewsletterForm(getDriver());
    }

    @Test(priority = 1, dataProvider = DataProviderNames.NAME_FIELD_BELOW_MAX, dataProviderClass = NewsletterDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(42)
    @QaseTitle("The \"Name\" field - shorter than maximum (maxLength - 1)")
    @Description("The \"Name\" field - shorter than maximum (maxLength - 1)")
    public void nameFieldBelowMax(String text) throws IllegalAccessException {

        newsletterForm.setName(text);
        Assert.assertEquals(text.length(), newsletterForm.getName().length(), "The output text is not equals to the expected");
    }

    @Test(priority = 2, dataProvider = DataProviderNames.NAME_FIELD_MAX, dataProviderClass = NewsletterDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(43)
    @QaseTitle("The \"Name\" field - maximum (maxLength)")
    @Description("The \"Name\" field - maximum (maxLength)")
    public void nameFieldMax(String text) throws IllegalAccessException {

        newsletterForm.setName(text);
        Assert.assertEquals(text.length(), newsletterForm.getName().length(), "The output text is not equals to the expected");
    }

    @Test(priority = 3, dataProvider = DataProviderNames.NAME_FIELD_ABOVE_MAX, dataProviderClass = NewsletterDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(44)
    @QaseTitle("The \"Name\" field - exceeding maximum (maxLength + 1)")
    @Description("The \"Name\" field - exceeding maximum (maxLength + 1)")
    public void nameFieldAboveMax(String text) throws IllegalAccessException {

        newsletterForm.setName(text);
        Assert.assertEquals(text.length() - 1, newsletterForm.getName().length(), "The output text is not equals to the expected");
    }

    @Test(priority = 4, dataProvider = DataProviderNames.EMAIL_FIELD_BELOW_MAX, dataProviderClass = NewsletterDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(45)
    @QaseTitle("The \"Email\" field - shorter than maximum (maxLength - 1)")
    @Description("The \"Email\" field - shorter than maximum (maxLength - 1)")
    public void emailFieldBelowMax(String text) throws IllegalAccessException {

        newsletterForm.setEmail(text);
        Assert.assertEquals(text.length(), newsletterForm.getEmail().length(), "The output text is not equals to the expected");
    }

    @Test(priority = 5, dataProvider = DataProviderNames.EMAIL_FIELD_MAX, dataProviderClass = NewsletterDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(46)
    @QaseTitle("The \"Email\" field - maximum (maxLength)")
    @Description("The \"Email\" field - maximum (maxLength)")
    public void emailFieldMax(String text) throws IllegalAccessException {

        newsletterForm.setEmail(text);
        Assert.assertEquals(text.length(), newsletterForm.getEmail().length(), "The output text is not equals to the expected");
    }

    @Test(priority = 6, dataProvider = DataProviderNames.EMAIL_FIELD_ABOVE_MAX, dataProviderClass = NewsletterDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(47)
    @QaseTitle("The \"Email\" field - exceeding maximum (maxLength + 1)")
    @Description("The \"Email\" field - exceeding maximum (maxLength + 1)")
    public void emailFieldAboveMax(String text) throws IllegalAccessException {

        newsletterForm.setEmail(text);
        Assert.assertEquals(text.length() - 1, newsletterForm.getEmail().length(), "The output text is not equals to the expected");
    }
}
