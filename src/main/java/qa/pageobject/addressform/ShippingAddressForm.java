package qa.pageobject.addressform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

import java.util.List;

public class ShippingAddressForm extends BasePage {

    public ShippingAddressForm(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "shipping_first_name")
    List<WebElement >firstNameField;

    @FindBy(id = "shipping_last_name")
    List<WebElement> lastNameField;

    @FindBy(id = "shipping_company")
    List<WebElement> companyField;

    @FindBy(id = "shiping_address_1")
    List<WebElement> addressField1;

    @FindBy(id = "shipping_address_2")
    List<WebElement> addressField2;

    @FindBy(id = "shipping_city")
    List<WebElement> cityField;

    @FindBy(id = "shipping_postcode")
    List<WebElement> postcodeField;

    @FindBy(xpath = "//ul[@class='woocommerce-error']")
    List<WebElement> errorMessage;


    protected void fill(WebElement element, String data) {

        element.clear();
        element.sendKeys(data);
    }

    public void setFirstName(String firstName) {

        fill(firstNameField.get(0), firstName);
    }

    public void setLastName(String lastName) {

        fill(lastNameField.get(0), lastName);
    }

    public void setCompany(String company) {

        fill(companyField.get(0), company);
    }

    public void setAddress_1(String address) {

        fill(addressField1.get(0), address);
    }

    public void setAddress_2(String address) {

        fill(addressField2.get(0), address);
    }

    public void setCity(String city) {

        fill(cityField.get(0), city);
    }

    public void setPostcode(String postcode) {

        fill(postcodeField.get(0), postcode);
    }

    public boolean isErrorMessageDisplayed() {

        return !(errorMessage.isEmpty());
    }

    public String getErrorMessageText() {

        return errorMessage.get(0).getText();
    }

    public boolean isVisible() {

        return !firstNameField.isEmpty() &&
               !lastNameField.isEmpty() &&
               !companyField.isEmpty() &&
               !addressField1.isEmpty() &&
               !addressField2.isEmpty() &&
               !postcodeField.isEmpty() &&
               !cityField.isEmpty();
    }
}
