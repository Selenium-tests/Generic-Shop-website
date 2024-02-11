package qa.testdataloader;

import com.google.gson.JsonParser;
import lombok.Getter;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TestdataLoader {

    private static final String path = "./src/test/resources/testdata/";
    @Getter
    private static String source;

    public static void load(String filename) {

        try {
            Reader reader = new FileReader(path + filename + ".json");
            JSONParser jsonParser = new JSONParser();
            Object object = jsonParser.parse(reader);
            source = object.toString();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
