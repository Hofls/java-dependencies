package hofls.com.github.dependency.injection;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class High implements Rating {

    @Override
    public int getRating() {
        return 5;
    }

}
