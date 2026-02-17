package hofls.com.github.schema;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SchemaGeneratorTest {

    @Test
    void generate() {
        SchemaGenerator.generate(getTables());
    }

    private List<SchemaGenerator.DBEntity> getTables() {
        List<SchemaGenerator.DBEntity> tables = new ArrayList<>();

        List<SchemaGenerator.DBField> userFields = new ArrayList<>();
        userFields.add(new SchemaGenerator.DBField("Unique Identifier", "id", "UUID"));
        userFields.add(new SchemaGenerator.DBField("Username / Login", "username", "String"));
        userFields.add(new SchemaGenerator.DBField("Morning Special Procedure Scheduled Timestamp", "morningAssignedAt", "OffsetDateTime"));
        userFields.add(new SchemaGenerator.DBField("Primary Email Address", "email", "String"));
        userFields.add(new SchemaGenerator.DBField("Administrative Comments", "comment", "String"));
        userFields.add(new SchemaGenerator.DBField("Internal User Notes", "notice", "String"));
        userFields.add(new SchemaGenerator.DBField("Evening Special Procedure Scheduled Timestamp", "eveningAssignedAt", "OffsetDateTime"));
        tables.add(new SchemaGenerator.DBEntity("User Account", "Account", userFields, "class"));

        List<SchemaGenerator.DBField> productFields = new ArrayList<>();
        productFields.add(new SchemaGenerator.DBField("Product Unique Identifier", "id", "UUID"));
        productFields.add(new SchemaGenerator.DBField("Product Title / Nomenclature", "title", "String"));
        productFields.add(new SchemaGenerator.DBField("Unit Retail Price", "price", "Double"));
        productFields.add(new SchemaGenerator.DBField("Current Inventory Availability Status", "isAvailable", "Boolean"));
        tables.add(new SchemaGenerator.DBEntity("Product Information", "Product", productFields, "class"));

        return tables;
    }

}

