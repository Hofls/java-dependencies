package hofls.com.github.generics.nested;

import java.util.List;

public class Page<T> {
    private List<T> content;
    private boolean lastPage;

    public Page(List<T> content) {
        this.content = content;
    }
}
