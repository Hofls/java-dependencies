package hofls.com.github.postgres.json;


import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import hofls.com.github.postgres.json.protocols.Protocol;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

// 1. If you want to use dates with jsonb - to set format use @JsonFormat, or set default format for all (ctrl+f "Alternative №1 to @JsonFormat")
// 2. If json structure have changed (e.g. class field got deleted), jackson will throw error during deserialization. To avoid it use @JsonIgnoreProperties(ignoreUnknown = true)
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

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<Protocol> protocols;

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
