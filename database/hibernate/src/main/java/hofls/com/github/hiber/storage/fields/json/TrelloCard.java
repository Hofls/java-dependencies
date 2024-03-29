package hofls.com.github.hiber.storage.fields.json;


import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class TrelloCard {

    // For info about jsonb look at test-containers (class KanbanCard)

    @Id
    @GeneratedValue
    private long id;

    @Type(type = "json") // better use jsonb
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
