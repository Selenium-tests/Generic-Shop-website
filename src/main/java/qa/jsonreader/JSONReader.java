package qa.jsonreader;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import qa.data.AddressFormData;
import qa.data.Credentials;
import qa.data.Link;
import qa.data.Newsletter;

import java.io.*;
import java.util.stream.IntStream;


public class JSONReader {
    private static final String filePath = "./resources/testdata.json";
    private static JSONObject jsonObject;


    private static JSONArray getJSONArray(String key, String node) {

        Object object = jsonObject.get(key);
        JSONObject jsonObject1 = (JSONObject) object;

        return jsonObject1.getJSONArray(node);
    }

    public static void read() throws JSONException, IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        Reader reader = new FileReader(filePath);

        Object object = jsonParser.parse(reader);
        jsonObject = new JSONObject(object.toString());
    }

    public static String[] get(String key, String node) throws JSONException {

        JSONArray jsonArray = getJSONArray(key, node);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(jsonArray::getString)
                .toArray(String[]::new);
    }

    public static String[] getQuantityFieldValue(String node) {

        JSONArray jsonArray = getJSONArray("quantityFieldValues", node);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new String(
                        jsonArray.getJSONObject(i).getString("value")
                ))
                .toArray(String[]::new);
    }

    public static Credentials[] getCredentials(String node) {

        JSONArray jsonArray = getJSONArray("login", node);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new Credentials(
                        jsonArray.getJSONObject(i).getString("email"),
                        jsonArray.getJSONObject(i).getString("password")
                ))
                .toArray(Credentials[]::new);
    }

    public static Link[] getLink(String node) {

        JSONArray jsonArray = getJSONArray("URLs", node);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new Link(
                        jsonArray.getJSONObject(i).getString("linkText"),
                        jsonArray.getJSONObject(i).getString("pageURL")
                ))
                .toArray(Link[]::new);
    }

    public static Newsletter[] getNewsletter(String node) {

        JSONArray jsonArray = getJSONArray("newsletter", node);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new Newsletter(
                        jsonArray.getJSONObject(i).getString("username"),
                        jsonArray.getJSONObject(i).getString("email")
                ))
                .toArray(Newsletter[]::new);
    }

    public static AddressFormData[] getAddressFormData(String node) {

        JSONArray jsonArray = getJSONArray("addressForm", node);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new AddressFormData(
                        jsonArray.getJSONObject(i).getString("country"),
                        jsonArray.getJSONObject(i).getString("firstName"),
                        jsonArray.getJSONObject(i).getString("lastName"),
                        jsonArray.getJSONObject(i).getString("companyName"),
                        jsonArray.getJSONObject(i).getString("address1"),
                        jsonArray.getJSONObject(i).getString("address2"),
                        jsonArray.getJSONObject(i).getString("city"),
                        jsonArray.getJSONObject(i).getString("postcode"),
                        jsonArray.getJSONObject(i).getString("phone"),
                        jsonArray.getJSONObject(i).getString("email"),
                        jsonArray.getJSONObject(i).getString("errorMessage")
                ))
                .toArray(AddressFormData[]::new);
    }
}
