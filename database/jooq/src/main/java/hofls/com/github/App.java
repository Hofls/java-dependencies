package hofls.com.github;

import com.example.jooq.generated.tables.Author;
import com.example.jooq.generated.tables.records.AuthorRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.ResultQuery;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.example.jooq.generated.Tables.AUTHOR;

public class App {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres")) {
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);

            // CREATE
            create.insertInto(AUTHOR, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
                    .values("John", "Doe")
                    .execute();

            // READ
            Result<AuthorRecord> records = create
                    .selectFrom(AUTHOR)
                    .where(AUTHOR.FIRST_NAME.eq("John"))
                    .orderBy(AUTHOR.ID.asc())
                    .fetch();
            for (AuthorRecord record : records) {
                var message = "ID: " + record.getId() +
                        ", First Name: " + record.getFirstName() +
                        ", Last Name: " + record.getLastName();
                System.out.println(message);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("DONE!");
    }
}
