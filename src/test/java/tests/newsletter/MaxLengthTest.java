package tests.newsletter;

import org.apache.commons.lang3.RandomStringUtils;
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
@Feature("Validation of user input")
public class MaxLengthTest extends BaseTest {

    private NewsletterForm newsletterForm;

    @BeforeMethod
    public void prepare() {

        goToPage(URLs.HOME_PAGE);
        newsletterForm = new NewsletterForm(getDriver());
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Footer")
    @Tag("Newsletter")
    @Tag("Fields")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(42)
    @QaseTitle("The \"Name\" field - shorter than maximum (maxLength - 1)")
    @Description("The \"Name\" field - shorter than maximum (maxLength - 1)")
    public void nameFieldBelowMax() throws IllegalAccessException {

        String name = RandomStringUtils.randomAlphabetic(newsletterForm.getNameFieldMaxLength() - 1);
        newsletterForm.setName(name);
        Assert.assertEquals(name.length(), newsletterForm.getName().length(), "The output text is not equals to the expected");
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Footer")
    @Tag("Newsletter")
    @Tag("Fields")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(43)
    @QaseTitle("The \"Name\" field - maximum (maxLength)")
    @Description("The \"Name\" field - maximum (maxLength)")
    public void nameFieldMax() throws IllegalAccessException {

        String name = RandomStringUtils.randomAlphabetic(newsletterForm.getNameFieldMaxLength());
        newsletterForm.setName(name);
        Assert.assertEquals(name.length(), newsletterForm.getName().length(), "The output text is not equals to the expected");
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Footer")
    @Tag("Newsletter")
    @Tag("Fields")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(44)
    @QaseTitle("The \"Name\" field - exceeding maximum (maxLength + 1)")
    @Description("The \"Name\" field - exceeding maximum (maxLength + 1)")
    public void nameFieldAboveMax() throws IllegalAccessException {

        String name = RandomStringUtils.randomAlphabetic(newsletterForm.getNameFieldMaxLength() + 1);
        newsletterForm.setName(name);
        Assert.assertEquals(name.length() - 1, newsletterForm.getName().length(), "The output text is not equals to the expected");
    }

    @Test(priority = 4)
    @Owner("Paweł Aksman")
    @Tag("Footer")
    @Tag("Newsletter")
    @Tag("Fields")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(45)
    @QaseTitle("The \"Email\" field - shorter than maximum (maxLength - 1)")
    @Description("The \"Email\" field - shorter than maximum (maxLength - 1)")
    public void emailFieldBelowMax() throws IllegalAccessException {

        String email = RandomStringUtils.randomAlphabetic(newsletterForm.getNameFieldMaxLength() - 1);
        newsletterForm.setEmail(email);
        Assert.assertEquals(email.length(), newsletterForm.getEmail().length(), "The output text is not equals to the expected");
    }

    @Test(priority = 5)
    @Owner("Paweł Aksman")
    @Tag("Footer")
    @Tag("Newsletter")
    @Tag("Fields")
    @Tag("Boundary value analysis")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @QaseId(46)
    @QaseTitle("The \"Email\" field - maximum (maxLength)")
    @Description("The \"Email\" field - maximum (maxLength)")
    public void emailFieldMax() throws IllegalAccessException {

        String email = RandomStringUtils.randomAlphabetic(newsletterForm.getNameFieldMaxLength());
        newsletterForm.setEmail(email);
        Assert.assertEquals(email.length(), newsletterForm.getEmail().length(), "The output text is not equals to the expected");
    }

    @Test(priority = 6)
    @Owner("Paweł Aksman")
    @Tag("Footer")
    @Tag("Newsletter")
    @Tag("Fields")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(47)
    @QaseTitle("The \"Email\" field - exceeding maximum (maxLength + 1)")
    @Description("The \"Email\" field - exceeding maximum (maxLength + 1)")
    public void emailFieldAboveMax() throws IllegalAccessException {

        String email = RandomStringUtils.randomAlphabetic(newsletterForm.getNameFieldMaxLength() + 1);
        newsletterForm.setEmail(email);
        Assert.assertEquals(email.length() - 1, newsletterForm.getEmail().length(), "The output text is not equals to the expected");
    }
}
