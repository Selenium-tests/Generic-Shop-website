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

    @DataProvider(name = "correctAddress")
    public Object[] correctAddress() throws JSONException {

        List<String[]> data = JSONReader.getArrays("address", "correct");

        return new Object[] {data};
    }

    @DataProvider(name = "addressIncorrectFirstName")
    public Object[] addressIncorrectFirstName() throws JSONException {

        List<String[]> data = JSONReader.getArrays("address", "incorrectFirstName");

        return new Object[] {data};
    }

    @DataProvider(name = "addressIncorrectLastName")
    public Object[] addressIncorrectLastName() throws JSONException {

        List<String[]> data = JSONReader.getArrays("address", "incorrectLastName");

        return new Object[] {data};
    }

    @DataProvider(name = "addressIncorrectPostcode")
    public Object[] addressIncorrectPostcode() throws JSONException {

        List<String[]> data = JSONReader.getArrays("address", "incorrectPostcode");

        return new Object[] {data};
    }

    @DataProvider(name = "addressIncorrectPhoneNumber")
    public Object[] getIncorrectPhoneNumber() throws JSONException {

        List<String[]> data = JSONReader.getArrays("address", "incorrectPhoneNumber");

        return new Object[] {data};
    }

    @DataProvider(name = "addressIncorrectEmail")
    public Object[] getIncorrectEmail() throws JSONException {

        List<String[]> data = JSONReader.getArrays("address", "incorrectEmail");

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
