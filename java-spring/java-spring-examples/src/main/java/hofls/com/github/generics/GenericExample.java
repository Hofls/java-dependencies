package hofls.com.github.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {

    public static class CustomList<E> {
        List<E> list = new ArrayList<>();

        public void add(E element) {
            list.add(element);
        }

        public E getFirst() {
            return list.get(0);
        }
    }

}
