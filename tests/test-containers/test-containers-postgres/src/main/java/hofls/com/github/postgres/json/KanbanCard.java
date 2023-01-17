package hofls.com.github.postgres.json;


import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class KanbanCard {

    @Id
    @GeneratedValue
    private long id;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Info info;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Object parameters;

    @Column
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Data
    public static class Info {
        String text;
        String status;
        Long priority;
        List<String> comments;
    }

    public enum CardType {
        TYPE_A,
        TYPE_B
    }

}
