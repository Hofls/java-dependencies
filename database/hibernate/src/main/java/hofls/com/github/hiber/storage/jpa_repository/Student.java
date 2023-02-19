package hofls.com.github.hiber.storage.jpa_repository;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Table(name = "student")
// @Where(clause = "deleted = false") - automatically adds condition to queries
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(of = "id")
public class Student {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Campus campus;

}
