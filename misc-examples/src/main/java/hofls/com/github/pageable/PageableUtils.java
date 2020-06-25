package hofls.com.github.pageable;

import java.util.ArrayList;
import java.util.List;

public class PageableUtils {

    private static final int MAX_REQUESTS_COUNT = 15;

    public static <R> List<R> sendRequests(Sender<R> sender, Pager<R> pager) throws Exception {
        List<R> responses = new ArrayList<>();
        int page = -1;
        boolean hasNextPage;
        do {
            page++;
            R response = sender.send(page);
            responses.add(response);
            hasNextPage = pager.hasNextPage(response);

            if (page > MAX_REQUESTS_COUNT) {
                throw new IllegalArgumentException("Too many consecutive requests");
            }
        } while (hasNextPage);

        return responses;
    }

    public interface Sender<R> {
        R send(int page) throws Exception;
    }

    public interface Pager<R> {
        boolean hasNextPage(R response);
    }
}
