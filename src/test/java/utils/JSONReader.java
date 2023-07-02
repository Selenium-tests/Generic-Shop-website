package utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Pair<String, String>> get(String key, String node, Pair<String, String> params) throws JSONException {

        Object object = jsonObject.get(key);
        JSONObject jsonObject1 = (JSONObject) object;
        JSONArray jsonArray = jsonObject1.getJSONArray(node);

        List<Pair<String, String>> pairList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            pairList.add(new Pair<>( jsonArray.getJSONObject(i).getString(params.first()),
                    jsonArray.getJSONObject(i).getString(params.second())));
        }

        return pairList;
    }

    public static List<String[]> getArrays(String key, String node) throws JSONException {

        Object object = jsonObject.get(key);
        JSONObject jsonObject1 =(JSONObject) object;
        JSONArray array = jsonObject1.getJSONArray(node);

        List<String[]> data = new ArrayList<>();

        for (int i = 0; i < array.length(); i++) {

            String[] temp = new String[array.getJSONArray(i).length()];

            for (int j = 0; j < array.getJSONArray(i).length(); j++) {

                temp[j] = array.getJSONArray(i).getString(j);
            }

            data.add(temp);
        }

        return data;
    }
}
