package hofls.com.github;

import hofls.com.github.service.CsvReader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class OnStartup {

    @PostConstruct
    public void init() {
        new CsvReader().readCsv();
    }

}
