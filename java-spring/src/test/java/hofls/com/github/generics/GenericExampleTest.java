package hofls.com.github.generics;

import org.junit.Assert;
import org.junit.Test;

public class GenericExampleTest {

    @Test
    public void aspect_should_add_exception_to_the_list() {
        GenericExample.CustomList<String> list = new GenericExample.CustomList<>();
        list.add("abc");
        list.add("def");
        Assert.assertEquals("abc", list.getFirst());
    }

}
