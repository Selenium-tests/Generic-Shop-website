package qa.provider;

import org.json.JSONException;
import org.testng.annotations.DataProvider;
import qa.jsonreader.JSONReader;


public class MyDataProvider {

    @DataProvider(name = "allBlackTops")
    public Object[] allBlackTops() {

        return JSONReader.getLink("allBlackTopsProducts");
    }

    @DataProvider(name = "highHeelShoesProducts")
    public Object[] highHeelShoes() {

        return JSONReader.getLink("highHeelShoesProducts");
    }

    @DataProvider(name = "mostWantedProducts")
    public Object[] mostWanted() {

        return JSONReader.getLink("mostWantedProducts");
    }

    @DataProvider(name = "scarfsProducts")
    public Object[] scarfsProducts() {

        return JSONReader.getLink("scarfsProducts");
    }

    @DataProvider(name = "onSaleProducts")
    public Object[] onSaleProducts() {

        return JSONReader.getLink("onSaleProducts");
    }

    @DataProvider(name = "featuredProducts")
    public Object[] featured() {

        return JSONReader.getLink("featuredProducts");
    }

    @DataProvider(name = "trendsProducts")
    public Object[] trends() {

        return JSONReader.getLink("trendsProducts");
    }

    @DataProvider(name = "blogs1")
    public Object[] blogs1() {

        return JSONReader.getLink("blogs_1");
    }

    @DataProvider(name = "blogs2")
    public Object[] blogs2() {

        return JSONReader.getLink("blogs_2");
    }

    @DataProvider(name = "correctCredentials")
    public Object[] correctCredentials() throws JSONException {

        return JSONReader.getCredentials("correctCredentials");
    }

    @DataProvider(name = "incorrectEmailFormat")
    public Object[] incorrectEmailFormat() throws JSONException {

        return JSONReader.getCredentials("incorrectEmailFormat");
    }

    @DataProvider(name = "blankEmailField")
    public Object[] blankEmailField() throws JSONException {

        return JSONReader.getCredentials("blankEmailField");
    }

    @DataProvider(name = "incorrectPassword")
    public Object[] incorrectPassword() throws JSONException {

        return JSONReader.getCredentials("incorrectPassword");
    }

    @DataProvider(name = "blankPasswordField")
    public Object[] blankPasswordField() throws JSONException {

        return JSONReader.getCredentials("blankPasswordField");
    }

    @DataProvider(name = "accountNavigation")
    public Object[] accountNavigation() {

        return JSONReader.getLink("accountNavigation");
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

    @DataProvider(name = "QF_min")
    public Object[] QF_min() {

        return JSONReader.getQuantityFieldValue("min");
    }

    @DataProvider(name = "QF_aboveMin")
    public Object[] QF_aboveMin() {

        return JSONReader.getQuantityFieldValue("aboveMin");
    }

    @DataProvider(name = "QF_nominal")
    public Object[] QF_nominal() {

        return JSONReader.getQuantityFieldValue("nominal");
    }

    @DataProvider(name = "QF_belowMax")
    public Object[] QF_belowMax() {

        return JSONReader.getQuantityFieldValue("belowMax");
    }

    @DataProvider(name = "QF_max")
    public Object[] QF_max() {

        return JSONReader.getQuantityFieldValue("max");
    }

    @DataProvider(name = "QF_belowZero")
    public Object[] QF_belowZero() {

        return JSONReader.getQuantityFieldValue("belowZero");
    }

    @DataProvider(name = "QF_aboveMax")
    public Object[] QF_aboveMax() {

        return JSONReader.getQuantityFieldValue("aboveMax");
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

        return JSONReader.getLink("tags");
        //return JSONReader.get("URLs", "tags", new Pair<>("linkText", "pageURL"));
    }

    @DataProvider(name = "recentPosts")
    public Object[] recentPosts() {

        return JSONReader.getLink("recentPosts");
    }

    @DataProvider(name = "newsletterCorrectCredentials")
    public Object[] newsletterCorrectCredentials() {

        return JSONReader.getNewsletter("correctCredentials");
    }

    @DataProvider(name = "newsletterBlankUsernameField")
    public Object[] newsletterBlankUsernameField() {

        return JSONReader.getNewsletter("blankUsernameField");
    }

    @DataProvider(name = "newsletterIncorrectEmailFormat")
    public Object[] newsletterIncorrectEmailFormat() {

        return JSONReader.getNewsletter("incorrectEmailFormat");
    }

    @DataProvider(name = "newsletterBlankEmailField")
    public Object[] newsletterBlankEmailField() {

        return JSONReader.getNewsletter("blankEmailField");
    }
}
