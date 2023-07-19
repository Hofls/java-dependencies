package hofls.com.github.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CsvReader {

    public void readCsv() {
        try (InputStream inputStream = CsvReader.class.getResourceAsStream("/example.csv");
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                Arrays.stream(data)
                        .forEach(value -> System.out.print(value + " "));

                for (int i = 0; i < data.length; i++) {
                    String value = data[i];
                    System.out.print(value + " ");
                }
                System.out.println(); // Print a new line after each row
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
