package hofls.com.github.postgres.json;


import com.fasterxml.jackson.databind.JsonNode;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import hofls.com.github.postgres.json.protocols.Protocol;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.*;
import java.util.List;

// 1. If you want to use dates with jsonb - to set format use @JsonFormat, or set default format for all (ctrl+f "Alternative №1 to @JsonFormat")
// 2. If json structure have changed (e.g. class field got deleted), jackson will throw error during deserialization. To avoid it use @JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Data
public class KanbanCard {

    @Id
    @GeneratedValue
    private long id;

    @JdbcTypeCode(SqlTypes.JSON)
    private Info info;

    @JdbcTypeCode(SqlTypes.JSON)
    private JsonNode parameters;

    @Column
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @JdbcTypeCode(SqlTypes.JSON)
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
