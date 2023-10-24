package qa.utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONReader {
    private static final String filePath = "./resources/testdata.json";

    private static JSONObject jsonObject;

    private static String fileToString() {

        try {

            InputStream is = Files.newInputStream(Paths.get(filePath));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

            String line = bufferedReader.readLine();
            StringBuilder stringBuilder = new StringBuilder();

            while (line != null) {

                stringBuilder.append(line).append("\n");
                line = bufferedReader.readLine();
            }

            return stringBuilder.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void read() throws JSONException {

        jsonObject = new JSONObject(fileToString());
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

    public static Pair<String, String>[] get(String key, String node, Pair<String, String> params) throws JSONException {

        Object object = jsonObject.get(key);
        JSONObject jsonObject1 = (JSONObject) object;
        JSONArray jsonArray = jsonObject1.getJSONArray(node);

        Pair<String, String>[] data = new Pair[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {
            data[i] = new Pair<>( jsonArray.getJSONObject(i).getString(params.first()),
                        jsonArray.getJSONObject(i).getString(params.second()));
        }

        return data;
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
