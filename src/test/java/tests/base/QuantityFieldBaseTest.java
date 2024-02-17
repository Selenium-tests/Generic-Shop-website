package tests.base;

import org.testng.Assert;
import qa.base.BaseTest;
import qa.quantityfield.QuantityField;

import java.math.BigInteger;

public class QuantityFieldBaseTest extends BaseTest {

    protected void checkValidationMessageVisibility(QuantityField quantityField) {

        Assert.assertNotEquals(quantityField.getValidationMessage(), "",
                "No validation message");
    }

    protected void setBelowMin(QuantityField quantityField) {

        String value = String.valueOf(Long.parseLong(quantityField.getMin()) - 1);
        quantityField.setQuantity(value);
    }
    protected void setMin(QuantityField quantityField) {

        quantityField.setQuantity(quantityField.getMin());
    }

    protected void setAboveMin(QuantityField quantityField) {

        String value = String.valueOf(Long.parseLong(quantityField.getMin()) + 1);
        quantityField.setQuantity(value);
    }

    protected void setBelowMax(QuantityField quantityField) {

        String value = String.valueOf(Long.MAX_VALUE - 1);
        quantityField.setQuantity(value);
    }

    protected void setMax(QuantityField quantityField) {

        String value = String.valueOf(Long.MAX_VALUE);
        quantityField.setQuantity(value);
    }

    protected void setAboveMax(QuantityField quantityField) {

        String value = String.valueOf(BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE));
        quantityField.setQuantity(value);
    }
}
