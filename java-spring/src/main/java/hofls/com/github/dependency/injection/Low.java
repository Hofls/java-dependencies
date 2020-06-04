package hofls.com.github.dependency.injection;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Low implements Rating {

    @Override
    public int getRating() {
        return 1;
    }

}
