package hofls.com.github.newlanguagefeatures.java9.interfaces;

import org.junit.jupiter.api.Test;

class LoggerImplTest {

    @Test
    void testLog() {
        LoggerImpl loggerImpl = new LoggerImpl();
        loggerImpl.log("message");
    }
}
