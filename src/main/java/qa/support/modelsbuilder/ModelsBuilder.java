package qa.support.modelsbuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONArray;
import org.json.JSONObject;
import qa.models.*;
import qa.support.testdataloader.TestdataLoader;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.stream.IntStream;


public class ModelsBuilder {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static JSONArray getJSONArray(String source, String key) {

        JSONObject jsonObject = new JSONObject(source);
        return jsonObject.getJSONArray(key);
    }

    private static  <T> T[] getObjectArray(String source, String key, Class<T> clazz) throws JsonProcessingException {

        JSONArray jsonArray = getJSONArray(source, key);
        T[] object = (T[]) java.lang.reflect.Array.newInstance(clazz, jsonArray.length());

        for (int i = 0; i < jsonArray.length(); i++) {

            object[i] = objectMapper.readValue(jsonArray.getJSONObject(i).toString(), clazz);
        }

        return object;
    }

    public static String[] getStrings(String key) {

        JSONArray jsonArray = getJSONArray(TestdataLoader.getSource(), key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(jsonArray::getString)
                .toArray(String[]::new);
    }

    public static Credentials[] getCredentials(String source, String key) throws JsonProcessingException {

        return getObjectArray(source, key, Credentials.class);
    }

    public static Credentials[] getCredentials(String key) throws JsonProcessingException {

        return getCredentials(TestdataLoader.getSource(), key);
    }

    public static NewsletterData[] getNewsletterData(String key) throws JsonProcessingException {

        return getObjectArray(TestdataLoader.getSource(), key, NewsletterData.class);
    }

    public static AddressData[] getAddressFormData(String key, String source) throws JsonProcessingException {

        return getObjectArray(source, key, AddressData.class);
    }

    public static AddressData[] getAddressFormData(String key) throws JsonProcessingException {

        return getAddressFormData(key, TestdataLoader.getSource());
    }

    public static ProductToCart[] getProductsToCart() throws JsonProcessingException {

        return getObjectArray(TestdataLoader.getSource(), "products", ProductToCart.class);
    }

    public static ThumbnailData[] getThumbnailsData() throws JsonProcessingException {

        return getObjectArray(TestdataLoader.getSource(), "thumbnails", ThumbnailData.class);
    }
}
