package hofls.com.github.rest.mirror;

import hofls.com.github.rest.common.config.CustomException;
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

    @Override
    public void throwCustomError() throws CustomException {
        throw new CustomException("D004", "Typical comment");
    }
}
