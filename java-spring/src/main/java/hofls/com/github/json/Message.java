package hofls.com.github.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Message {

    /** If you want some weird format (not default) */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime messageTime;
}
