package hofls.com.github.nullsafe;

import hofls.com.github.nullsafe.types.Address;
import hofls.com.github.nullsafe.types.Area;
import hofls.com.github.nullsafe.types.CustomType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NullCheckDemoTest {

    @Test
    public void should_convert_null_to_string() throws Exception {
        String actual_a = NullCheckDemo.getAreaName_MEDIOCRE_EXAMPLE(null);
        String actual_b = NullCheckDemo.getAreaName_BAD_EXAMPLE(null);
        String actual_c = NullCheckDemo.getAreaName_BEST_EXAMPLE(null);
        assertEquals(null, actual_a);
        assertEquals(null, actual_b);
        assertEquals(null, actual_c);
    }

    @Test
    public void should_convert_half_filled_object_to_string() throws Exception {
        Address address = new Address();
        address.setCustomType(new CustomType());

        String actual_a = NullCheckDemo.getAreaName_MEDIOCRE_EXAMPLE(address);
        String actual_b = NullCheckDemo.getAreaName_BAD_EXAMPLE(address);
        String actual_c = NullCheckDemo.getAreaName_BEST_EXAMPLE(address);
        assertEquals(null, actual_a);
        assertEquals(null, actual_b);
        assertEquals(null, actual_c);
    }

    @Test
    public void should_convert_fully_filled_object_to_string() throws Exception {
        Area area = new Area();
        area.setName("Saharan desert");

        CustomType customType = new CustomType();
        customType.setArea(area);

        Address address = new Address();
        address.setCustomType(customType);

        String actual_a = NullCheckDemo.getAreaName_MEDIOCRE_EXAMPLE(address);
        String actual_b = NullCheckDemo.getAreaName_BAD_EXAMPLE(address);
        String actual_c = NullCheckDemo.getAreaName_BEST_EXAMPLE(address);
        assertEquals("Saharan desert", actual_a);
        assertEquals("Saharan desert", actual_b);
        assertEquals("Saharan desert", actual_c);
    }


}
