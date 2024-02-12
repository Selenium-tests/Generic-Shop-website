package qa.testdataloader;

import lombok.Getter;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TestdataLoader {

    private static final String path = "./src/test/resources/testdata/";
    @Getter
    private static String source;

    public static String fetch(String filename) {

        try {
            Reader reader = new FileReader(path + filename + ".json");
            JSONParser jsonParser = new JSONParser();
            Object object = jsonParser.parse(reader);
            return object.toString();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void load(String filename) {

        source = fetch(filename);
    }

    public static String loadQuickly(String filename) {

        return fetch(filename);
    }
}
