package hofls.com.github.context.need.a.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** We must test this class, so we can't just exclude it (like BrokenService.java) */
@Component
public class ControllerToTest {

    @Autowired
    private BrokenKafka kafka;

    @Autowired
    private BrokenRedis brokenRedis;

}
