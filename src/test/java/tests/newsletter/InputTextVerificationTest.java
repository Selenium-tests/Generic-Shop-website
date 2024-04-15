package tests.newsletter;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.support.constans.URLs;
import qa.pageobject.footer.NewsletterForm;
import tests.base.BaseTest;

@Epic("E2E")
@Feature("The newsletter form fields")
public class InputTextVerificationTest extends BaseTest {

    private NewsletterForm newsletterForm;
    private final String TEXT = "This is the text";

    @BeforeMethod
    public void create() {

        goToPage(URLs.HOME_PAGE);
        newsletterForm = new NewsletterForm(getDriver());
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Footer")
    @Tag("Newsletter")
    @Tag("Fields")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(40)
    @QaseTitle("Verification of the \"Name\" field text input")
    @Description("Verification of the \"Name\" field text input")
    public void nameField() throws IllegalAccessException {

        newsletterForm.setName(TEXT);

        Assert.assertEquals(newsletterForm.getName(), TEXT, "Incorrect the \"Name\" field output");
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Footer")
    @Tag("Newsletter")
    @Tag("Fields")
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(41)
    @QaseTitle("Verification of the \"Email\" field text input")
    @Description("Verification of the \"Email\" field text input")
    public void emailField() throws IllegalAccessException {

        newsletterForm.setEmail(TEXT);

        Assert.assertEquals(newsletterForm.getEmail(), TEXT, "Incorrect the \"Email\" field output");
    }
}
