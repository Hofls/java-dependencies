package hofls.com.github.schema;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SchemaGeneratorTest {

    @Test
    void generate() {
        new SchemaGenerator().generate(getTables());
    }

    private List<SchemaGenerator.DBTable> getTables() {
        List<SchemaGenerator.DBTable> tables = new ArrayList<>();

        List<SchemaGenerator.DBField> userFields = new ArrayList<>();
        userFields.add(new SchemaGenerator.DBField("Идентификатор", "id", "UUID"));
        userFields.add(new SchemaGenerator.DBField("Имя пользователя", "username", "String"));
        userFields.add(new SchemaGenerator.DBField("Дата и время назначения на утренние спец. процедуры", "morningAssignedAt", "OffsetDateTime"));
        userFields.add(new SchemaGenerator.DBField("Почта", "email", "String"));
        userFields.add(new SchemaGenerator.DBField("Комментарий", "comment", "String"));
        userFields.add(new SchemaGenerator.DBField("Заметка", "notice", "String"));
        userFields.add(new SchemaGenerator.DBField("Дата и время назначения на вечерние спец. процедуры", "eveningAssignedAt", "OffsetDateTime"));
        tables.add(new SchemaGenerator.DBTable("Аккаунт пользователя", userFields));

        List<SchemaGenerator.DBField> productFields = new ArrayList<>();
        productFields.add(new SchemaGenerator.DBField("Идентификатор", "id", "UUID"));
        productFields.add(new SchemaGenerator.DBField("Наименование", "title", "String"));
        productFields.add(new SchemaGenerator.DBField("Цена", "price", "Double"));
        productFields.add(new SchemaGenerator.DBField("В наличии", "isAvailable", "Boolean"));
        tables.add(new SchemaGenerator.DBTable("Продукт", productFields));

        return tables;
    }

}

