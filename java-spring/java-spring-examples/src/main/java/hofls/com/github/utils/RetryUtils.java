package hofls.com.github.utils;


import java.util.concurrent.TimeUnit;


public class RetryUtils {

    public static <R> R retry(Action<R> action) throws Exception {
        return retry(action, 5);
    }

    /** Tries again if error appears */
    static <R> R retry(Action<R> action, int maxRetriesCount) throws Exception {
        for (int retry = 0; retry <= maxRetriesCount; retry++) {
            try {
                return action.execute(); // SUCCESS
            } catch (Exception e) {
                if (retry == maxRetriesCount) {
                    throw e; // FAIL
                }
                TimeUnit.SECONDS.sleep(1); // Wait for some time, maybe error will go away
            }
        }
        return null; // shouldn't be reached
    }

    public interface Action<R> {
        /** Executes an action */
        R execute() throws Exception;
    }
}
