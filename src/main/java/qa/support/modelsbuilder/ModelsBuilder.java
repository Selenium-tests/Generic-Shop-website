package qa.support.modelsbuilder;

import org.json.JSONArray;
import org.json.JSONObject;
import qa.models.*;
import qa.support.testdataloader.TestdataLoader;

import java.util.stream.IntStream;


public class ModelsBuilder {

    private static JSONArray getJSONArray(String source, String key) {

        JSONObject jsonObject = new JSONObject(source);
        return jsonObject.getJSONArray(key);
    }

    public static Credentials[] getCredentials(String source, String key) {

        JSONArray jsonArray = getJSONArray(source, key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new Credentials(
                        jsonArray.getJSONObject(i).getString("emailOrUsername"),
                        jsonArray.getJSONObject(i).getString("password"),
                        jsonArray.getJSONObject(i).getString("message")
                ))
                .toArray(Credentials[]::new);
    }

    public static Credentials[] getCredentials(String key) {

        return getCredentials(TestdataLoader.getSource(), key);
    }

    public static String[] getStrings(String key) {

        JSONArray jsonArray = getJSONArray(TestdataLoader.getSource(), key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(jsonArray::getString)
                .toArray(String[]::new);
    }

    public static LinkData[] getLinkData(String key) {

        JSONArray jsonArray = getJSONArray(TestdataLoader.getSource(), key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new LinkData(
                        jsonArray.getJSONObject(i).getString("link"),
                        jsonArray.getJSONObject(i).getString("url")
                ))
                .toArray(LinkData[]::new);
    }

    public static NewsletterData[] getNewsletterData(String key) {

        JSONArray jsonArray = getJSONArray(TestdataLoader.getSource(), key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new NewsletterData(
                        jsonArray.getJSONObject(i).getString("username"),
                        jsonArray.getJSONObject(i).getString("email"),
                        jsonArray.getJSONObject(i).getString("message")
                ))
                .toArray(NewsletterData[]::new);
    }

    public static String[] getNewsletterFieldText(String fieldType, String key) {

        JSONObject jsonObject = new JSONObject(TestdataLoader.getSource());
        JSONObject field = jsonObject.getJSONObject(fieldType);
        JSONArray jsonArray = field.getJSONArray(key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(jsonArray::getString)
                .toArray(String[]::new);
    }

    public static AddressData[] getAddressFormData(String key, String source) {

        JSONArray jsonArray = getJSONArray(source, key);

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

    public static AddressData[] getAddressFormData(String key) {

        return getAddressFormData(key, TestdataLoader.getSource());
    }

    public static ProductToCart[] getProductsToCart() {

        JSONArray jsonArray = getJSONArray(TestdataLoader.getSource(), "products");

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new ProductToCart(
                        jsonArray.getJSONObject(i).getString("url"),
                        jsonArray.getJSONObject(i).getString("quantity")
                ))
                .toArray(ProductToCart[]::new);
    }

    public static ThumbnailData[] getThumbnailsData() {

        JSONArray jsonArray = getJSONArray(TestdataLoader.getSource(),"thumbnails");

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new ThumbnailData(
                        String.valueOf(jsonArray.getJSONObject(i).getInt("tycheProduct")),
                        jsonArray.getJSONObject(i).getString("link")
                ))
                .toArray(ThumbnailData[]::new);
    }
}
