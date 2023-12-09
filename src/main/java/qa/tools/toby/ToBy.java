package qa.tools.toby;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.xml.sax.Locator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ToBy {

    private static final String LOCATOR = "locator";
    private static final String BY = "by";
    private static final String FOUND_BY = "foundBy";

    public static By get(WebElement element) throws IllegalAccessException {

        if(element instanceof Proxy proxy) {

            InvocationHandler handler = Proxy.getInvocationHandler(proxy);
            Object object = FieldUtils.readField(handler, LOCATOR, true);
            Object by = FieldUtils.readField(object, BY, true);

            return FromString.get(by.toString());

        } else if (element instanceof RemoteWebElement remoteWebElement) {

            Object foundBy = FieldUtils.readField(remoteWebElement, FOUND_BY, true);
            String[] split = foundBy.toString().split("-> ");

            return FromString.get(split[1]);

        } else {

            return (By) FieldUtils.readField(element, BY, true);
        }
    }
}
