package hofls.com.github.nullcheck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NullCheckDemoTest {

    @Test
    public void should_convert_null_to_string() throws Exception {
        String actual_a = NullCheckDemo.getAreaName_GOOD_EXAMPLE(null);
        String actual_b = NullCheckDemo.getAreaName_BAD_EXAMPLE(null);
        String actual_c = NullCheckDemo.getAreaName_BEST_EXAMPLE(null);
        assertEquals(null, actual_a);
        assertEquals(null, actual_b);
        assertEquals(null, actual_c);
    }

    @Test
    public void should_convert_half_filled_object_to_string() throws Exception {
        NullCheckDemo.Address address = new NullCheckDemo.Address();
        address.setCustomType(new NullCheckDemo.CustomType());

        String actual_a = NullCheckDemo.getAreaName_GOOD_EXAMPLE(address);
        String actual_b = NullCheckDemo.getAreaName_BAD_EXAMPLE(address);
        String actual_c = NullCheckDemo.getAreaName_BEST_EXAMPLE(address);
        assertEquals(null, actual_a);
        assertEquals(null, actual_b);
        assertEquals(null, actual_c);
    }

    @Test
    public void should_convert_fully_filled_object_to_string() throws Exception {
        NullCheckDemo.Area area = new NullCheckDemo.Area();
        area.setName("Saharan desert");

        NullCheckDemo.CustomType customType = new NullCheckDemo.CustomType();
        customType.setArea(area);

        NullCheckDemo.Address address = new NullCheckDemo.Address();
        address.setCustomType(customType);

        String actual_a = NullCheckDemo.getAreaName_GOOD_EXAMPLE(address);
        String actual_b = NullCheckDemo.getAreaName_BAD_EXAMPLE(address);
        String actual_c = NullCheckDemo.getAreaName_BEST_EXAMPLE(address);
        assertEquals("Saharan desert", actual_a);
        assertEquals("Saharan desert", actual_b);
        assertEquals("Saharan desert", actual_c);
    }


}
