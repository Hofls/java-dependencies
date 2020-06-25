package hofls.com.github.pageable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageableUtilsTest {

    @Test
    public void testSendPageableRequests_should_return_results() throws Exception {
        MockService mockService = new MockService();
        List<MockResponse> result =
                PageableUtils.sendRequests(mockService::send, MockResponse::hasMorePages);

        assertEquals(0, result.get(0).page);
        assertEquals(3, result.get(3).page);
        assertEquals(4, result.size());
    }

    @Test
    public void testSendPageableRequests_should_prevent_endless_cycle() throws Exception {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            PageableUtils.sendRequests(page -> new MockResponse(1), response -> true);
        });
        assertEquals("Too many consecutive requests", exception.getMessage());
    }

    public static class MockService {
        public MockResponse send(int page) {
            return new MockResponse(page);
        }
    }

    public static class MockResponse {
        public int page;

        public MockResponse(int page) {
            this.page = page;
        }

        public boolean hasMorePages() {
            return page < 3;
        }
    }
}
