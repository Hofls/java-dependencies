package hofls.com.github.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ObjectToClone implements Serializable {
    private List<SubObject> subObjects = new ArrayList<>();

    @Data
    @AllArgsConstructor
    public static class SubObject implements Serializable {
        Long value;
    }
}
