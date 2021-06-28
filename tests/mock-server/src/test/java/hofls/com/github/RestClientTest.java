package hofls.com.github;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.integration.ClientAndServer;

import static org.mockserver.matchers.Times.exactly;
import static org.mockserver.model.HttpClassCallback.callback;
import static org.mockserver.model.HttpRequest.request;

public class RestClientTest {

    private static ClientAndServer mockServer;
    private static Integer PORT = 9960;
    private static String ADDRESS = "localhost";

    @BeforeClass
    public static void startServer() {
        mockServer = ClientAndServer.startClientAndServer(PORT);
    }

    @AfterClass
    public static  void stopServer() {
        mockServer.stop();
    }

    @Test
    public void generateTest() {
        createPostEndpoint();
        sendPostRequest();
    }

    private void createPostEndpoint(){
        new MockServerClient(ADDRESS, PORT)
                .when(
                        request()
                                .withMethod("POST")
                                .withPath("/validate")
                ).callback(
                    callback()
                        .withCallbackClass("hofls.com.github.CallbackHandler")
        );
    }

    private org.apache.http.HttpResponse sendPostRequest() {
        String url = "http://127.0.0.1:9960/validate";
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-type", "application/json");
        org.apache.http.HttpResponse response=null;

        try {
            StringEntity stringEntity = new StringEntity("{username: 'foo', password: 'bar'}");
            post.getRequestLine();
            post.setEntity(stringEntity);
            response=client.execute(post);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

}
