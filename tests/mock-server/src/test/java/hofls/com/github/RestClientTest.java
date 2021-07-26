package hofls.com.github;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.integration.ClientAndServer;


import static org.junit.Assert.assertEquals;
import static org.mockserver.model.HttpClassCallback.callback;
import static org.mockserver.model.HttpRequest.request;

public class RestClientTest {

    private static ClientAndServer mockServer;
    private static Integer PORT = 9960;
    private static String ADDRESS = "localhost";

    @BeforeAll
    public static void startServer() {
        mockServer = ClientAndServer.startClientAndServer(PORT);
    }

    @AfterAll
    public static  void stopServer() {
        mockServer.stop();
    }

    @BeforeEach
    public void resetEnpoints() {
        mockServer.reset();
    }

    @Test
    public void test_mirror() {
        createPostEndpoint("MirrorCallback");
        String actualResponse = sendPostRequest();
        String expectedResponse = "{username: 'foo', password: 'bar'}";

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void test_response() {
        createPostEndpoint("ResponseCallback");
        String actualResponse = sendPostRequest();
        String expectedResponse = "{\"numbers\":[1, 2, 3]}";

        assertEquals(expectedResponse, actualResponse);
    }

    private void createPostEndpoint(String callbackClass){
        new MockServerClient(ADDRESS, PORT)
                .when(
                        request()
                                .withMethod("POST")
                                .withPath("/hello-world")
                ).callback(
                    callback()
                        .withCallbackClass("hofls.com.github.callbacks." + callbackClass)
        );
    }

    private String sendPostRequest() {
        try {
            String url = "http://127.0.0.1:9960/hello-world";

            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost request = new HttpPost(url);
            StringEntity params = new StringEntity("{username: 'foo', password: 'bar'}");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            return new BasicResponseHandler().handleResponse(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
