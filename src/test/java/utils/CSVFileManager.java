package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileManager {

    public static List<String[]> loadFile(String fileName) throws IOException, CsvValidationException {

        FileReader fileReader = new FileReader(fileName);
        List<String[]> data = null;

        try {

            CSVReader csvReader = new CSVReader(fileReader);

            data = new ArrayList<>();
            String[] line;

            while ((line = csvReader.readNext()) != null) {

                data.add(line);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return data;
    }
}
