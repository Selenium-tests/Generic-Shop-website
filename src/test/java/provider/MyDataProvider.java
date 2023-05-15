package provider;

import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;
import utils.CSVFileManager;

import java.io.IOException;
import java.util.List;

public class MyDataProvider {

    private String path = "./resources/test data/";

    private List<String[]> helper(String filemane) throws CsvValidationException, IOException {

        List<String[]> data = CSVFileManager.loadFile(path + filemane);

        return data;
    }
    @DataProvider(name = "getCorrectLoginData")
    public Object[][] getCorrectLoginData() throws CsvValidationException, IOException {

        List<String[]> data = helper("login/correctData.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getIncorrectUsernameData")
    public Object[][] getIncorrectEmailAddress() throws CsvValidationException, IOException {

        List<String[]> data = helper("login/incorrectEmail.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getBlankUsernameFieldData")
    public Object[][] getBlankEmailAddressField() throws CsvValidationException, IOException {

        List<String[]> data = helper("login/emptyEmailForm.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getIncorrectPasswordData")
    public Object[][] getIncorrectPassword() throws CsvValidationException, IOException {

        List<String[]> data = helper("login/incorrectPassword.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getBlankPasswordFieldData")
    public Object[][] getBlankPasswordField() throws CsvValidationException, IOException {

        List<String[]> data = helper("login/emptyPasswordForm.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getBlankNameFieldNewsletterData")
    public Object[][] getBlankNameFieldNewsletterData() throws CsvValidationException, IOException {

        List<String[]> data = helper("newsletter/blankNameField.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getIncorrectEmailNewsletterData")
    public Object[][] getIncorrectEmailNewsletterData() throws CsvValidationException, IOException {

        List<String[]> data = helper("newsletter/incorrectEmail.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getCorrectPhrase")
    public Object[][] getCorrectPhrase() throws IOException, CsvValidationException {

        List<String[]> data = helper("search engine/correctPhrases.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getPartOfCorrectPhrase")
    public Object[][] getPartOfCorrectPhrase() throws IOException, CsvValidationException {

        List<String[]> data = helper("search engine/partsOfCorrectPhrase.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getUpperLower")
    public Object[][] getUpperLower() throws IOException, CsvValidationException {

        List<String[]> data = helper("search engine/upperLowerCases.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getIncorrectPhrase")
    public Object[][] getIncorrectPhrase() throws IOException, CsvValidationException {

        List<String[]> data = helper("search engine/incorrectPhrases.csv");

        return new Object[][] {{data}};
    }

    @DataProvider(name = "getSpecialSigns")
    public Object[][] getSpecialSigns() throws CsvValidationException, IOException {

        List<String[]> data = helper("search engine/specialSigns.csv");

        return new Object[][] {{data}};
    }
}
