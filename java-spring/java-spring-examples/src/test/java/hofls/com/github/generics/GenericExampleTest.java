package hofls.com.github.generics;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenericExampleTest {

    @Test
    public void aspect_should_add_exception_to_the_list() {
        GenericExample.CustomList<String> list = new GenericExample.CustomList<>();
        list.add("abc");
        list.add("def");
        assertEquals("abc", list.getFirst());
    }

}
