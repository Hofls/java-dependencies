package hofls.com.github.mapstruct.misc;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDto {

    private String name;
    private String city;
    private List<PrivilegeDto> privileges;

}
