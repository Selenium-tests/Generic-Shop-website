package qa.jsonreader;

import org.json.JSONArray;
import org.json.JSONObject;
import qa.data.*;
import qa.testdataloader.TestdataLoader;

import java.util.stream.IntStream;


public class ModelsBuilder {
    public static Credentials[] getCredentials(String key) {

        String source = TestdataLoader.getSource();
        JSONObject jsonObject = new JSONObject(source);
        JSONArray jsonArray = jsonObject.getJSONArray(key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new Credentials(
                        jsonArray.getJSONObject(i).getString("emailOrUsername"),
                        jsonArray.getJSONObject(i).getString("password"),
                        jsonArray.getJSONObject(i).getString("message")
                ))
                .toArray(Credentials[]::new);
    }

    public static String[] getStrings(String key) {

        String source = TestdataLoader.getSource();
        JSONObject jsonObject = new JSONObject(source);
        JSONArray jsonArray = jsonObject.getJSONArray(key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(jsonArray::getString)
                .toArray(String[]::new);
    }

    public static LinkData[] getLinkData(String key) {

        String source = TestdataLoader.getSource();
        JSONObject jsonObject = new JSONObject(source);
        JSONArray jsonArray = jsonObject.getJSONArray(key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new LinkData(
                        jsonArray.getJSONObject(i).getString("link"),
                        jsonArray.getJSONObject(i).getString("url")
                ))
                .toArray(LinkData[]::new);
    }

    public static NewsletterData[] getNewsletterData(String key) {

        String source = TestdataLoader.getSource();
        JSONObject jsonObject = new JSONObject(source);
        JSONArray jsonArray = jsonObject.getJSONArray(key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new NewsletterData(
                        jsonArray.getJSONObject(i).getString("username"),
                        jsonArray.getJSONObject(i).getString("email"),
                        jsonArray.getJSONObject(i).getString("message")
                ))
                .toArray(NewsletterData[]::new);
    }

    public static AddressData[] getAddressFormData(String key) {

        return getAddressFormData(key, TestdataLoader.getSource());
    }

    public static AddressData[] getAddressFormData(String key, String source) {

        JSONObject jsonObject = new JSONObject(source);
        JSONArray jsonArray = jsonObject.getJSONArray(key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new AddressData(
                        jsonArray.getJSONObject(i).getString("country"),
                        jsonArray.getJSONObject(i).getString("firstName"),
                        jsonArray.getJSONObject(i).getString("lastName"),
                        jsonArray.getJSONObject(i).getString("company"),
                        jsonArray.getJSONObject(i).getString("address"),
                        jsonArray.getJSONObject(i).getString("addressLine2"),
                        jsonArray.getJSONObject(i).getString("city"),
                        jsonArray.getJSONObject(i).getString("postcode"),
                        jsonArray.getJSONObject(i).getString("phone"),
                        jsonArray.getJSONObject(i).getString("email"),
                        jsonArray.getJSONObject(i).getString("message")
                ))
                .toArray(AddressData[]::new);
    }

    public static ProductToCart[] getProductsToCart() {

        String source = TestdataLoader.getSource();
        JSONObject jsonObject = new JSONObject(source);
        JSONArray jsonArray = jsonObject.getJSONArray("products");

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new ProductToCart(
                        jsonArray.getJSONObject(i).getString("url"),
                        jsonArray.getJSONObject(i).getString("quantity")
                ))
                .toArray(ProductToCart[]::new);
    }
}
