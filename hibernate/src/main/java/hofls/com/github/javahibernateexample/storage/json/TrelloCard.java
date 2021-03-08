package hofls.com.github.javahibernateexample.storage.json;


import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class)
})
public class TrelloCard {

    @Id
    @GeneratedValue
    private long id;

    @Type(type = "json")
    private Info info;

    @Data
    public static class Info {
        String text;
        String status;
        Long priority;
        List<String> comments;
    }

}
