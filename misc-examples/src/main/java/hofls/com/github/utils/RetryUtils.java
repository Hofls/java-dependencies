package hofls.com.github.utils;


import java.util.concurrent.TimeUnit;


public class RetryUtils {

    public static void retry(Action action) throws Exception {
        retry(action, 5);
    }

    /** Tries again if error appears */
    static void retry(Action action, int maxRetriesCount) throws Exception {
        for (int retry = 0; retry <= maxRetriesCount; retry++) {
            try {
                action.execute();
                return; // SUCCESS
            } catch (Exception e) {
                if (retry == maxRetriesCount) {
                    throw e; // FAIL
                }
                TimeUnit.SECONDS.sleep(1); // Wait for some time, maybe error goes away
            }
        }
    }

    public interface Action {
        void execute() throws Exception;
    }
}
