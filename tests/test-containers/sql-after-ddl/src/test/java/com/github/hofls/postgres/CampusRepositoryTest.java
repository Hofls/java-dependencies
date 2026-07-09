package com.github.hofls.postgres;

import com.github.hofls.postgres.campus.Campus;
import com.github.hofls.postgres.campus.CampusRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CampusRepositoryTest extends BaseTest {

    @Autowired
    private CampusRepository repository;

    @Test
    @Sql(config = @SqlConfig(encoding = "UTF-8"), scripts = {"/init.sql", "trigger_test.sql"})
    public void trigger_test() {
        Campus campus = repository.findById(23L).orElseThrow();
        assertEquals("Extrodee. NewYork - Advanced status", campus.getTextForSearch());
    }

}
