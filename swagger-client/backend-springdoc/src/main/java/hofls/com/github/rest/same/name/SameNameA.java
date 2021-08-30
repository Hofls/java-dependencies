package hofls.com.github.rest.same.name;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/same-name-userA")
@RestController
public class SameNameA {

    @GetMapping()
    public User getUser() {
        return new User("John");
    }

    // Without this annotation swagger will generate incorrect model
    // Because there is two classes with same name (User)
    @Schema(name = "MainUser")
    public static class User {

        private String normalName;

        public User(String normalName) {
            this.normalName = normalName;
        }

        public String getNormalName() {
            return normalName;
        }

        public void setNormalName(String normalName) {
            this.normalName = normalName;
        }
    }


}
