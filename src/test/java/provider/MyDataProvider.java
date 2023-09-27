package provider;

import org.json.JSONException;
import org.testng.annotations.DataProvider;
import utils.JSONReader;
import utils.Pair;

import java.util.List;

public class MyDataProvider {

    @DataProvider(name = "correctLoginData")
    public Object[] correctLoginData() throws JSONException {

        List<Pair<String, String>> data = JSONReader.get("login", "correct", new Pair<>("email", "password"));

        return new Object[] {data};
    }

    @DataProvider(name = "incorrectUsername")
    public Object[] incorrectUsername() throws JSONException {

        List<Pair<String, String>> data = JSONReader.get("login", "incorrectEmail", new Pair<>("email", "password"));

        return new Object[] {data};
    }

    @DataProvider(name = "noUsername")
    public Object[] noUsername() throws JSONException {

        List<Pair<String, String>> data = JSONReader.get("login", "noEmail", new Pair<>("email", "password"));

        return new Object[] {data};
    }

    @DataProvider(name = "incorrectPassword")
    public Object[] incorrectPassword() throws JSONException {

        List<Pair<String, String>> data = JSONReader.get("login", "incorrectPassword", new Pair<>("email", "password"));

        return new Object[] {data};
    }

    @DataProvider(name = "noPassword")
    public Object[] noPassword() throws JSONException {

        List<Pair<String, String>> data = JSONReader.get("login", "noPassword", new Pair<>("email", "password"));

        return new Object[] {data};
    }

    @DataProvider(name = "getBlankNameFieldNewsletterData")
    public Object[] getBlankNameFieldNewsletterData() throws JSONException {

        List<Pair<String, String>> data = JSONReader.get("newsletter", "noUsername", new Pair<>("username", "email"));

        return new Object[] {data};
    }

    @DataProvider(name = "getIncorrectEmailNewsletterData")
    public Object[] getIncorrectEmailNewsletterData() throws JSONException {

        List<Pair<String, String>> data = JSONReader.get("newsletter", "incorrectEmail", new Pair<>("username", "email"));

        return new Object[] {data};
    }

    @DataProvider(name = "getCorrectPhrase")
    public Object[] getCorrectPhrase() throws JSONException {

        String[] data = JSONReader.get("searchEngine", "correct");

        return new Object[] {data};
    }

    @DataProvider(name = "getPartOfCorrectPhrase")
    public Object[] getPartOfCorrectPhrase() throws JSONException {

        String[] data = JSONReader.get("searchEngine", "part");

        return new Object[] {data};
    }

    @DataProvider(name = "getUpperLower")
    public Object[] getUpperLower() throws JSONException {

        String[] data = JSONReader.get("searchEngine", "upperLower");

        return new Object[] {data};
    }

    @DataProvider(name = "getIncorrectPhrase")
    public Object[] getIncorrectPhrase() throws JSONException {

        String[] data = JSONReader.get("searchEngine", "incorrect");

        return new Object[] {data};
    }

    @DataProvider(name = "getSpecialSigns")
    public Object[] getSpecialSigns() throws JSONException {

        String[] data = JSONReader.get("searchEngine", "naughtyStrings");

        return new Object[] {data};
    }

    @DataProvider(name = "AF_correctAddress")
    public Object[] AF_correctAddress() throws JSONException {

        String[] data = JSONReader.get("addressForm", "correctAddress");

        return new Object[] {data};
    }

    @DataProvider(name = "AF_additionalField")
    public Object[] AF_additionalField() throws JSONException {

        String[] data = JSONReader.get("addressForm", "additionalField");

        return new Object[] {data};
    }

    @DataProvider(name = "AF_incorrectFirstName")
    public Object[] AF_incorrectFirstName() throws JSONException {

        String[] data = JSONReader.get("addressForm", "incorrectFirstName");

        return new Object[] {data};
    }

    @DataProvider(name = "AF_incorrectLastName")
    public Object[] AF_incorrectLastName() throws JSONException {

        String[] data = JSONReader.get("addressForm", "incorrectLastName");

        return new Object[] {data};
    }

    @DataProvider(name = "AF_incorrectPostcode")
    public Object[] AF_incorrectPostcode() throws JSONException {

        String[] data = JSONReader.get("addressForm", "incorrectPostcode");

        return new Object[] {data};
    }

    @DataProvider(name = "AF_incorrectPhoneNumber")
    public Object[] AF_incorrectPhoneNumber() throws JSONException {

        String[] data = JSONReader.get("addressForm", "incorrectPhoneNumber");

        return new Object[] {data};
    }

    @DataProvider(name = "AF_incorrectEmail")
    public Object[] AF_incorrectEmail() throws JSONException {

        String[] data = JSONReader.get("addressForm", "incorrectEmail");

        return new Object[] {data};
    }

    @DataProvider(name = "correctCountryName")
    public Object[] correctCountryName() throws JSONException {

        String[] data = JSONReader.get("countries", "correct");

        return new Object[] {data};
    }

    @DataProvider(name = "incorrectCountryName")
    public Object[] incorrectCountryName() throws JSONException {

        String[] data = JSONReader.get("countries", "incorrect");

        return new Object[] {data};
    }
}
