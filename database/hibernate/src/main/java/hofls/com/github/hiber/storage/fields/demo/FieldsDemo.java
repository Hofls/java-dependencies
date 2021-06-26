package hofls.com.github.hiber.storage.fields.demo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FieldsDemo {

    @Id
    @SequenceGenerator(name = "seq", sequenceName = "entity_data_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private long id;

    @Column(length = 30)
    private String messageTopic;

    @Enumerated(EnumType.STRING) // Store in DB as text, instead of number
    private MessageStatus messageStatus;

}
