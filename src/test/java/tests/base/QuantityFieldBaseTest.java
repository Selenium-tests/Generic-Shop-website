package tests.base;

import org.testng.Assert;
import qa.pageobject.quantityfield.QuantityField;

import java.math.BigInteger;
import java.util.function.Consumer;

public class QuantityFieldBaseTest extends BaseTest {

    protected<T> void checkMessageVisibility(Consumer<T> consumer, T object) {

        try {
            consumer.accept(object);
        } catch (Exception e) {
            Assert.fail("No message was displayed");
        }
    }

    protected void checkMessageContent(String actual, String expected) {

        Assert.assertTrue(actual.contains(expected),
                "The message does not contain the \"" + expected + "\"");
    }

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
