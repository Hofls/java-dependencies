package hofls.com.github.rest.mirror;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mirror implements IMirror {

    @Override
    public String reflect(String value) {
        return value + " (reflected)";
    }

    @Override
    public void throwError() {
        throw new IllegalArgumentException("Wrong order id");
    }

}
