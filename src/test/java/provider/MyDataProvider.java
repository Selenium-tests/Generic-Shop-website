package provider;

import com.opencsv.exceptions.CsvValidationException;
import org.json.JSONException;
import org.testng.annotations.DataProvider;
import utils.CSVFileManager;
import utils.JSONReader;

import java.io.IOException;
import java.util.List;

public class MyDataProvider {

    private final String path = "./resources/test data/";

    private List<String[]> loadFile(String filename) throws CsvValidationException, IOException {

        List<String[]> data = CSVFileManager.loadFile(path + filename);

        return data;
    }

    @DataProvider(name = "getCorrectLoginData")
    public Object[][] getCorrectLoginData() throws CsvValidationException, IOException {

        List<String[]> data = loadFile("login/correctData.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getIncorrectUsernameData")
    public Object[][] getIncorrectEmailAddress() throws CsvValidationException, IOException {

        List<String[]> data = loadFile("login/incorrectEmail.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getBlankUsernameFieldData")
    public Object[][] getBlankEmailAddressField() throws CsvValidationException, IOException {

        List<String[]> data = loadFile("login/emptyEmailForm.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getIncorrectPasswordData")
    public Object[][] getIncorrectPassword() throws CsvValidationException, IOException {

        List<String[]> data = loadFile("login/incorrectPassword.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getBlankPasswordFieldData")
    public Object[][] getBlankPasswordField() throws CsvValidationException, IOException {

        List<String[]> data = loadFile("login/emptyPasswordForm.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getBlankNameFieldNewsletterData")
    public Object[][] getBlankNameFieldNewsletterData() throws CsvValidationException, IOException {

        List<String[]> data = loadFile("newsletter/blankNameField.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getIncorrectEmailNewsletterData")
    public Object[][] getIncorrectEmailNewsletterData() throws CsvValidationException, IOException {

        List<String[]> data = loadFile("newsletter/incorrectEmail.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getCorrectPhrase")
    public Object[] getCorrectPhrase() throws JSONException {

        String[] data = JSONReader.get("searchEngine", "correct");

        return new Object[][] {data};
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

        return new Object[][] {data};
    }

    @DataProvider(name = "getSpecialSigns")
    public Object[] getSpecialSigns() throws JSONException {

        String[] data = JSONReader.get("searchEngine", "naughtyStrings");

        return new Object[] {data};
    }

    @DataProvider(name = "getCorrectBillingAddress")
    public Object[][] getCorrectBillingAddress() throws CsvValidationException, IOException {

        List<String[]> data = loadFile("addresses/billingCorrectData.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getIncorrectFirstName")
    public Object[][] getIncorrectFirstName() throws CsvValidationException, IOException {

        List<String[]> data = loadFile("addresses/incorrectFirstName.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getIncorrectLastName")
    public Object[][] getIncorrectLastName() throws CsvValidationException, IOException {

        List<String[]> data = loadFile("addresses/incorrectLastName.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getIncorrectPostcode")
    public Object[][] getIncorrectPostcode() throws CsvValidationException, IOException {

        List<String[]> data = loadFile("addresses/incorrectPostcode.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getIncorrectPhoneNumber")
    public Object[][] getIncorrectPhoneNumber() throws CsvValidationException, IOException {

        List<String[]> data = loadFile("addresses/incorrectPhoneNumber.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getIncorrectEmail")
    public Object[][] getIncorrectEmail() throws CsvValidationException, IOException {

        List<String[]> data = loadFile("addresses/incorrectEmail.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getCorrectCountryNames")
    public Object[][] getCorrectCountryNames() throws CsvValidationException, IOException {

        List<String[]> data = loadFile("addresses/correctCountryNames.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getIncorrectCountryNames")
    public Object[][] getIncorrectCountryNames() throws CsvValidationException, IOException {

        List<String[]> data = loadFile("addresses/incorrectCountryNames.csv");

        return new Object[][] {{data}};
    }
}
