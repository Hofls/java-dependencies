package hofls.com.github.hiber.storage.sql_file_report;

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