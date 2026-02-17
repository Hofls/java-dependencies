package hofls.com.github;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SchemaGeneratorTest {

    @Test
    void generate() {
        new SchemaGenerator().generate(getTables());
    }

    private List<SchemaGenerator.Table> getTables() {
        List<SchemaGenerator.Table> tables = new ArrayList<>();

        List<SchemaGenerator.Field> userFields = new ArrayList<>();
        userFields.add(new SchemaGenerator.Field("Идентификатор", "id", "UUID"));
        userFields.add(new SchemaGenerator.Field("Имя пользователя", "username", "String"));
        userFields.add(new SchemaGenerator.Field("Дата и время назначения на утренние спец. процедуры", "morningAssignedAt", "OffsetDateTime"));
        userFields.add(new SchemaGenerator.Field("Почта", "email", "String"));
        userFields.add(new SchemaGenerator.Field("Комментарий", "comment", "String"));
        userFields.add(new SchemaGenerator.Field("Заметка", "notice", "String"));
        userFields.add(new SchemaGenerator.Field("Дата и время назначения на вечерние спец. процедуры", "eveningAssignedAt", "OffsetDateTime"));
        tables.add(new SchemaGenerator.Table("Аккаунт пользователя", userFields));

        List<SchemaGenerator.Field> productFields = new ArrayList<>();
        productFields.add(new SchemaGenerator.Field("Идентификатор", "id", "UUID"));
        productFields.add(new SchemaGenerator.Field("Наименование", "title", "String"));
        productFields.add(new SchemaGenerator.Field("Цена", "price", "Double"));
        productFields.add(new SchemaGenerator.Field("В наличии", "isAvailable", "Boolean"));
        tables.add(new SchemaGenerator.Table("Продукт", productFields));

        return tables;
    }

}

