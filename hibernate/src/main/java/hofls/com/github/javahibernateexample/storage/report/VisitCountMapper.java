package hofls.com.github.javahibernateexample.storage.report;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VisitCountMapper implements RowMapper<VisitCount> {

    @Override
    public VisitCount mapRow(ResultSet resultSet, int i) throws SQLException {

        VisitCount visitCount = VisitCount.builder()
                .id(resultSet.getLong("id"))
                .age(resultSet.getLong("age"))
                .build();

        return visitCount;
    }
}