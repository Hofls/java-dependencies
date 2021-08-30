package hofls.com.github.rest.same.name;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/same-name-userB")
@RestController
public class SameNameB {

    @GetMapping()
    public User getUser() {
        return new User("NYC, ST John street 23");
    }

    public static class User {

        private String address;

        public User(String address) {
            this.address = address;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }


}
