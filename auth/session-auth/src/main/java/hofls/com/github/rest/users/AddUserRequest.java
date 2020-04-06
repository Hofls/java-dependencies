package hofls.com.github.rest.users;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class AddUserRequest {
    @ApiModelProperty(value = "User name", example = "Minx")
    private String name;
    @ApiModelProperty(value = "User password", example = "4321")
    private String password;
    @ApiModelProperty(value = "ROLES", example = "['ROLE_ADMIN', 'ROLE_MODERATOR']")
    private List<String> professions;
}
