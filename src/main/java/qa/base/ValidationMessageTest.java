package qa.base;

import org.testng.Assert;
import qa.pageobject.productpage.QuantityField;

public class ValidationMessageTest extends BaseTest {

    protected void checkValidationMessageVisibility(QuantityField quantityField) {

        Assert.assertNotEquals(quantityField.getValidationMessage(), "",
                "No validation message");
    }
}
