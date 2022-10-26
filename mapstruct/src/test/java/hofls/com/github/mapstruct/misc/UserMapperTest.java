package hofls.com.github.mapstruct.misc;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserMapperTest {

    @Test
    public void oneTrueMethod() {
        User user = new User();
        user.setName("John");

        List<Privilege> privileges = new ArrayList<>();
        privileges.add(new Privilege(23L));
        UserDto userDto = UserMapper.INSTANCE.oneTrueMethod(user, privileges);

        Assert.assertEquals("John", userDto.getName());
        Assert.assertEquals(Long.valueOf(23), userDto.getPrivileges().get(0).getId());
    }


    @Test
    public void should_copy_properties() {
        User user = new User();
        user.setName("John");
        UserDto userDto = new UserDto();
        userDto.setCity("London");

        UserMapper.INSTANCE.copyProperties(user, userDto);

        Assert.assertEquals("London", userDto.getCity());
        Assert.assertEquals("John", userDto.getName());
    }

    @Test
    public void should_set_city() {
        User user = new User();
        user.setName("John");

        UserDto userDto = UserMapper.INSTANCE.toDto(user);

        Assert.assertEquals("New York", userDto.getCity());
        Assert.assertEquals("John", userDto.getName());
    }

}