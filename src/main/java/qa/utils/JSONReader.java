package qa.utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;


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

        Object object = jsonObject.get(key);
        JSONObject jsonObject1 = (JSONObject) object;
        JSONArray jsonArray = jsonObject1.getJSONArray(node);

        String[] data = new String[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {

            data[i] = jsonArray.getString(i);
        }

        return data;
    }

    public static Credentials[] getCredentials(String node) {

        JSONArray jsonArray = getJSONArray("login", node);

        Credentials[] credentials = new Credentials[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {

            credentials[i] = new Credentials(
                    jsonArray.getJSONObject(i).getString("email"),
                    jsonArray.getJSONObject(i).getString("password")
            );
        }

        return credentials;
    }

    public static Link[] getLink(String node) {

        JSONArray jsonArray = getJSONArray("URLs", node);

        Link[] links = new Link[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {

            links[i] = new Link(
                    jsonArray.getJSONObject(i).getString("linkText"),
                    jsonArray.getJSONObject(i).getString("pageURL")
            );
        }

        return links;
    }

    public static Newsletter[] getNewsletter(String node) {

        JSONArray jsonArray = getJSONArray("newsletter", node);

        Newsletter[] newsletters = new Newsletter[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {

            newsletters[i] = new Newsletter(
                    jsonArray.getJSONObject(i).getString("username"),
                    jsonArray.getJSONObject(i).getString("email")
            );
        }

        return newsletters;
    }

    public static AddressFormData[] getAddressFormData(String node) {

        Object object = jsonObject.get("addressForm");
        JSONObject jsonObject1 = (JSONObject) object;
        JSONArray jsonArray = jsonObject1.getJSONArray(node);

        AddressFormData[] addressFormData = new AddressFormData[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {

            AddressFormData data = new AddressFormData();

            data.setCountry(jsonArray.getJSONObject(i).getString("country"));
            data.setFirstName(jsonArray.getJSONObject(i).getString("firstName"));
            data.setLastName(jsonArray.getJSONObject(i).getString("lastName"));
            data.setCompanyName(jsonArray.getJSONObject(i).getString("companyName"));
            data.setAddress1(jsonArray.getJSONObject(i).getString("address1"));
            data.setAddress2(jsonArray.getJSONObject(i).getString("address2"));
            data.setCity(jsonArray.getJSONObject(i).getString("city"));
            data.setPostcode(jsonArray.getJSONObject(i).getString("postcode"));
            data.setPhone(jsonArray.getJSONObject(i).getString("phone"));
            data.setEmail(jsonArray.getJSONObject(i).getString("email"));
            data.setErrorMessage(jsonArray.getJSONObject(i).getString("errorMessage"));

            addressFormData[i] = data;
        }

        return addressFormData;
    }
}
