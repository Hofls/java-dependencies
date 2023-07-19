package hofls.com.github;

import hofls.com.github.service.CsvReader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class OnStartup {

    @PostConstruct
    public void init() {
        List<String> linesA = new CsvReader().readCsv(
                "/example.csv",
                cells -> cells[0] + ";" + cells[1]);
        System.out.println(linesA);

        List<String> linesB = new CsvReader().readCsv(
                "/math.csv",
                cells -> cells[0] + "+" + cells[1] + "=" + cells[2]);
        System.out.println(linesB);
    }

}
