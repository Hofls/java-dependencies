package hofls.com.github;

import org.mockserver.mock.action.ExpectationCallback;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import static org.mockserver.model.HttpResponse.response;

public class CallbackHandler implements ExpectationCallback {

    public HttpResponse handle(HttpRequest httpRequest) {
        String body = httpRequest.getBodyAsString();
        return response()
                .withStatusCode(200).withBody(body);
    }



}
