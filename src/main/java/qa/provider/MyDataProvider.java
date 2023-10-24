package qa.provider;

import org.json.JSONException;
import org.testng.annotations.DataProvider;
import qa.utils.JSONReader;
import qa.utils.Pair;

public class MyDataProvider {

    @DataProvider(name = "allBlackTops")
    public Object[] allBlackTops() {

        return JSONReader.get("URLs", "allBlackTopsProducts", new Pair<>("linkText", "pageURL"));
    }

    @DataProvider(name = "highHeelShoesProducts")
    public Object[] highHeelShoes() {

        return JSONReader.get("URLs", "highHeelShoesProducts", new Pair<>("linkText", "pageURL"));
    }

    @DataProvider(name = "mostWantedProducts")
    public Object[] mostWanted() {

        return JSONReader.get("URLs", "mostWantedProducts", new Pair<>("linkText", "pageURL"));
    }

    @DataProvider(name = "featuredProducts")
    public Object[] featured() {

        return JSONReader.get("URLs", "featuredProducts", new Pair<>("linkText", "pageURL"));
    }

    @DataProvider(name = "trendsProducts")
    public Object[] trends() {

        return JSONReader.get("URLs", "trendsProducts", new Pair<>("linkText", "pageURL"));
    }

    @DataProvider(name = "blogs")
    public Object[] blogs() {

        return JSONReader.get("URLs", "blogs", new Pair<>("linkText", "pageURL"));
    }

    @DataProvider(name = "correctCredentials")
    public Object[] correctCredentials() throws JSONException {

        return JSONReader.get("login", "correctCredentials", new Pair<>("email", "password"));
    }

    @DataProvider(name = "incorrectEmailFormat")
    public Object[] incorrectEmailFormat() throws JSONException {

        return JSONReader.get("login", "incorrectEmailFormat", new Pair<>("email", "password"));
    }

    @DataProvider(name = "blankEmailField")
    public Object[] blankEmailField() throws JSONException {

        return JSONReader.get("login", "blankEmailField", new Pair<>("email", "password"));
    }

    @DataProvider(name = "incorrectPassword")
    public Object[] incorrectPassword() throws JSONException {

        return  JSONReader.get("login", "incorrectPassword", new Pair<>("email", "password"));

    }

    @DataProvider(name = "blankPasswordField")
    public Object[] blankPasswordField() throws JSONException {

        return JSONReader.get("login", "blankPasswordField", new Pair<>("email", "password"));
    }

    @DataProvider(name = "accountNavigation")
    public Object[] accountNavigation() {

        return JSONReader.get("URLs", "accountNavigation", new Pair<>("linkText", "pageURL"));
    }

    @DataProvider(name = "correctPhrase")
    public Object[] correctPhrase() throws JSONException {

        return JSONReader.get("searchEngine", "correctPhrase");
    }

    @DataProvider(name = "upperAndLowerCases")
    public Object[] upperAndLowerCases() throws JSONException {

        return JSONReader.get("searchEngine", "upperAndLowerCases");
    }

    @DataProvider(name = "partOfCorrectPhrase")
    public Object[] partOfCorrectPhrase() throws JSONException {

        return JSONReader.get("searchEngine", "partOfCorrectPhrase");
    }

    @DataProvider(name = "incorrectPhrase")
    public Object[] incorrectPhrase() throws JSONException {

        return JSONReader.get("searchEngine", "incorrectPhrase");
    }

    @DataProvider(name = "strangePhrase")
    public Object[] strangePhrase() throws JSONException {

        return JSONReader.get("searchEngine", "strangePhrase");
    }

    @DataProvider(name = "AF_correctAddress")
    public Object[] AF_correctAddress() throws JSONException {

        return JSONReader.getAddressFormData("correctAddressData");
    }

    @DataProvider(name = "AF_incorrectFirstName")
    public Object[] AF_incorrectFirstName() throws JSONException {

        return JSONReader.getAddressFormData("incorrectFirstName");
    }

    @DataProvider(name = "AF_incorrectLastName")
    public Object[] AF_incorrectLastName() throws JSONException {

        return JSONReader.getAddressFormData("incorrectLastName");
    }

    @DataProvider(name = "AF_incorrectPostcode")
    public Object[] AF_incorrectPostcode() throws JSONException {

        return JSONReader.getAddressFormData("incorrectPostcode");
    }

    @DataProvider(name = "AF_incorrectPhoneNumber")
    public Object[] AF_incorrectPhoneNumber() throws JSONException {

        return JSONReader.getAddressFormData("incorrectPhoneNumber");
    }

    @DataProvider(name = "AF_incorrectEmail")
    public Object[] AF_incorrectEmail() throws JSONException {

        return JSONReader.getAddressFormData("incorrectEmail");
    }

    @DataProvider(name = "correctCountryName")
    public Object[] correctCountryName() throws JSONException {

        return JSONReader.get("countries", "correctCountryName");
    }

    @DataProvider(name = "incorrectCountryName")
    public Object[] incorrectCountryName() throws JSONException {

        return JSONReader.get("countries", "incorrectCountryName");
    }

    @DataProvider(name = "tags")
    public Object[] tags() {

        return JSONReader.get("URLs", "tags", new Pair<>("linkText", "pageURL"));
    }

    @DataProvider(name = "recentPosts")
    public Object[] recentPosts() {

        return JSONReader.get("URLs", "recentPosts", new Pair<>("linkText", "pageURL"));
    }

    @DataProvider(name = "newsletterCorrectCredentials")
    public Object[] newsletterCorrectCredentials() {

        return JSONReader.get("newsletter", "correctCredentials", new Pair<>("username", "email"));
    }

    @DataProvider(name = "newsletterBlankUsernameField")
    public Object[] newsletterBlankUsernameField() {

        return JSONReader.get("newsletter", "blankUsernameField", new Pair<>("username", "email"));
    }

    @DataProvider(name = "newsletterIncorrectEmailFormat")
    public Object[] newsletterIncorrectEmailFormat() {

        return JSONReader.get("newsletter", "incorrectEmailFormat", new Pair<>("username", "email"));
    }

    @DataProvider(name = "newsletterBlankEmailField")
    public Object[] newsletterBlankPasswordField() {

        return JSONReader.get("newsletter", "blankEmailField", new Pair<>("username", "email"));
    }
}