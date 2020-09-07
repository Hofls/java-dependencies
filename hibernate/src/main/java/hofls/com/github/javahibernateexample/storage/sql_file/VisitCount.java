package hofls.com.github.javahibernateexample.storage.sql_file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class VisitCount {

    private Long id;
    private Long age;

}