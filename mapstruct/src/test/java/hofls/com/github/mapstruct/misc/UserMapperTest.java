package hofls.com.github.mapstruct.misc;



import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserMapperTest {

    @Test
    public void oneTrueMethod() {
        User user = new User();
        user.setName("John");

        List<Privilege> privileges = new ArrayList<>();
        privileges.add(new Privilege(23L));
        UserDto userDto = UserMapper.INSTANCE.oneTrueMethod(user, privileges);

        assertEquals("John", userDto.getName());
        assertEquals(Long.valueOf(23), userDto.getPrivileges().get(0).getId());
    }


    @Test
    public void should_copy_properties() {
        User user = new User();
        user.setName("John");
        UserDto userDto = new UserDto();
        userDto.setCity("London");

        UserMapper.INSTANCE.copyProperties(user, userDto);

        assertEquals("London", userDto.getCity());
        assertEquals("John", userDto.getName());
    }

    @Test
    public void should_set_city() {
        User user = new User();
        user.setName("John");

        UserDto userDto = UserMapper.INSTANCE.toDto(user);

        assertEquals("New York", userDto.getCity());
        assertEquals("John", userDto.getName());
    }

}