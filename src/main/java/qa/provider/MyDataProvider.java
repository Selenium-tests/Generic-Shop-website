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

    @DataProvider(name = "stateCountyField")
    public Object[] stateCountyField() {

        return JSONReader.get("addressForm", "stateCountyField");
    }

    @DataProvider(name = "stateCountyDropdownList")
    public Object[] stateCountyDropdownList() {

        return JSONReader.get("addressForm", "stateCountyDropdownList");
    }

    @DataProvider(name = "countyDropdownList")
    public Object[] countyDropdownList() {

        return JSONReader.get("addressForm", "countyDropdownList");
    }

    @DataProvider(name = "stateDropdownList")
    public Object[] stateDropdownList() {

        return JSONReader.get("addressForm", "stateDropdownList");
    }

    @DataProvider(name = "districtDropdownList")
    public Object[] districtDropdownList() {

        return JSONReader.get("addressForm", "districtDropdownList");
    }

    @DataProvider(name = "provinceDropdownList")
    public Object[] provinceDropdownList() {

        return JSONReader.get("addressForm", "provinceDropdownList");
    }

    @DataProvider(name = "regionField")
    public Object[] regionField() {

        return JSONReader.get("addressForm", "regionField");
    }

    @DataProvider(name = "regionDropdownList")
    public Object[] regionDropdownList() {

        return JSONReader.get("addressForm", "regionDropdownList");
    }

    @DataProvider(name = "prefectureDropdownList")
    public Object[] prefectureDropdownList() {

        return JSONReader.get("addressForm", "prefectureDropdownList");
    }

    @DataProvider(name = "municipalityField")
    public Object[] municipalityField() {

        return JSONReader.get("addressForm", "municipalityField");
    }

    @DataProvider(name = "stateZoneDropdownList")
    public Object[] stateZoneDropdownList() {

        return JSONReader.get("addressForm", "stateZoneDropdownList");
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

    @DataProvider(name = "AF_withoutFirstName")
    public Object[] AF_withoutFirstName() {

        return JSONReader.getAddressFormData("withoutFirstName");
    }

    @DataProvider(name = "AF_withoutLastName")
    public Object[] AF_withoutLastName() {

        return JSONReader.getAddressFormData("withoutLastName");
    }

    @DataProvider(name = "AF_withoutAddress")
    public Object[] AF_withoutAddress() {

        return JSONReader.getAddressFormData("withoutAddress");
    }

    @DataProvider(name = "AF_withoutCity")
    public Object[] AF_withoutCity() {

        return JSONReader.getAddressFormData("withoutCity");
    }

    @DataProvider(name = "AF_withoutPostcode")
    public Object[] AF_withoutPostcode() {

        return JSONReader.getAddressFormData("withoutPostcode");
    }

    @DataProvider(name = "AF_withoutPhone")
    public Object[] AF_withoutPhone() {

        return JSONReader.getAddressFormData("withoutPhone");
    }

    @DataProvider(name = "AF_withoutEmail")
    public Object[] AF_withoutEmail() {

        return JSONReader.getAddressFormData("withoutEmail");
    }

    @DataProvider(name = "correctCountryName")
    public Object[] correctCountryName() throws JSONException {

        return JSONReader.get("countries", "correctCountryName");
    }

    @DataProvider(name = "incorrectCountryName")
    public Object[] incorrectCountryName() throws JSONException {

        return JSONReader.get("countries", "incorrectCountryName");
    }

    @DataProvider(name = "QF_characters1")
    public Object[] QF_characters1() {

        return JSONReader.get("quantityField", "first");
    }

    @DataProvider(name = "QF_characters2")
    public Object[] QF_Characters2() {

        return JSONReader.get("quantityField", "second");
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
