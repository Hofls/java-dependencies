package hofls.com.github.jgroups.purchase;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class Purchase implements Serializable {
    private int id;
    private OffsetDateTime dateTime;

    public Purchase(int id, OffsetDateTime dateTime) {
        this.id = id;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                '}';
    }
}
