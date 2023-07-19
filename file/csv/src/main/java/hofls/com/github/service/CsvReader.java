package hofls.com.github.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CsvReader {

    public static  <T> List<T> csvToList(String file, Function<String[], T> mapper) {
        List<T> result = new ArrayList<>();
        try (InputStream inputStream = CsvReader.class.getResourceAsStream(file);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                T value = mapper.apply(data);
                result.add(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


}
