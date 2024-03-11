package tests.newsletter;

import io.qameta.allure.*;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.pageobject.footer.NewsletterForm;
import tests.base.BaseTest;

@Epic("E2E")
@Feature("The newsletter form fields")
public class InputTextVerificationTest extends BaseTest {

    private NewsletterForm newsletterForm;
    private final String TEXT = "This is the text";

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        newsletterForm = new NewsletterForm(getDriver());
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(40)
    @QaseTitle("Verification of the \"Name\" field text input")
    @Description("Verification of the \"Name\" field text input")
    public void nameField() throws IllegalAccessException {

        newsletterForm.setName(TEXT);

        Assert.assertEquals(newsletterForm.getName(), TEXT, "Incorrect the \"Name\" field output");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(41)
    @QaseTitle("Verification of the \"Email\" field text input")
    @Description("Verification of the \"Email\" field text input")
    public void emailField() throws IllegalAccessException {

        newsletterForm.setEmail(TEXT);

        Assert.assertEquals(newsletterForm.getEmail(), TEXT, "Incorrect the \"Email\" field output");
    }
}
