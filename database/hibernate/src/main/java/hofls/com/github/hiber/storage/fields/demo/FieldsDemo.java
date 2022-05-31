package hofls.com.github.hiber.storage.fields.demo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "fields_demo",
        indexes = {
                @Index(name = "fields_message_topic_index", columnList = "messageId"),
                @Index(name = "fields_message_status_index", columnList = "messageStatus, messageId")
        })
public class FieldsDemo {

    @Id
    @SequenceGenerator(name = "seq", sequenceName = "entity_data_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private long id;

    @Column(length = 30, nullable = false, unique = true)
    private String messageId;

    @Enumerated(EnumType.STRING) // Store in DB as text, instead of number
    private MessageStatus messageStatus;

}
