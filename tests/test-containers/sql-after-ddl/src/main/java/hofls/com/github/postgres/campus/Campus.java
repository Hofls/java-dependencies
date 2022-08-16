package hofls.com.github.postgres.campus;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Campus {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String address;

    private String status;

    private String textForSearch;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTextForSearch() {
        return textForSearch;
    }

    public void setTextForSearch(String textForSearch) {
        this.textForSearch = textForSearch;
    }
}
