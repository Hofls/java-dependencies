package hofls.com.github.rest.token;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class GenerateTokenRequest {
    @ApiModelProperty(value = "ROLES", example = "['ROLE_ADMIN', 'ROLE_MODERATOR']")
    private List<String> roles;
}
