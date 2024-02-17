package tests.newsletter;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.pageobject.footer.NewsletterForm;
import tests.base.BaseTest;

public class InputTextValidationTest extends BaseTest {

    private NewsletterForm newsletterForm;
    private final String text = "This is the text";

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        newsletterForm = new NewsletterForm(getDriver());
    }

    @Test
    public void usernameField() throws IllegalAccessException {

        newsletterForm.setUsername(text);

        Assert.assertEquals(newsletterForm.getUsername(), text, "Incorrect username");
    }

    @Test
    public void emailField() throws IllegalAccessException {

        newsletterForm.setEmail(text);

        Assert.assertEquals(newsletterForm.getEmail(), text, "Incorrect email");
    }
}
