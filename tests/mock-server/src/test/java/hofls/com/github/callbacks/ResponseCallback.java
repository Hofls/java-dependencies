package hofls.com.github.callbacks;

import org.mockserver.mock.action.ExpectationCallback;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import static org.mockserver.model.HttpResponse.response;

public class ResponseCallback implements ExpectationCallback {

    public HttpResponse handle(HttpRequest httpRequest) {
        // Sometimes also needed .withHeaders(new Header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString()))
        return response()
                .withStatusCode(200).withBody("{\"numbers\":[1, 2, 3]}");
    }



}
