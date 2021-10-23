package hofls.com.github.hiber.storage.sql_file_report;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@Repository
@Slf4j
public class VisitCountRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public VisitCountRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<VisitCount> read(Long excludeBranchId, LocalDate minBirthDate) throws IOException {

        List<VisitCount> results = jdbcTemplate.query(
                getReportSql(),
                new MapSqlParameterSource()
                        .addValue("excludeBranchId", excludeBranchId)
                        .addValue("minBirthDate", minBirthDate),
                new VisitCountMapper());

        return results;
    }

    static String getReportSql() throws IOException {
        File resourcesDirectory =
                new File(
                        "src/main/resources/reports/visit_count_report.sql");
        return new String(
                Files.readAllBytes(Paths.get(resourcesDirectory.getAbsolutePath())),
                StandardCharsets.UTF_8); // todo replace with 'readString'
    }
}