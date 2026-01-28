package hofls.com.github.hiber.storage.fields.json;


import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Data
public class TrelloCard {

    // For info about jsonb look at test-containers (class KanbanCard)

    @Id
    @GeneratedValue
    private long id;

    @JdbcTypeCode(SqlTypes.JSON) // better use jsonb
    @Column(columnDefinition = "json")
    private Info info;

    @Data
    public static class Info {
        String text;
        String status;
        Long priority;
        List<String> comments;
    }

}
