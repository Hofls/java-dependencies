package hofls.com.github.service;

import com.github.hofls.MessageServicePortType;
import com.github.hofls.types.GetMessageRequest;
import com.github.hofls.types.GetMessageResponse;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@Component
@WebService(targetNamespace = "http://github.com/hofls/", name = "reportServicePortType")
public class MessageServicePortTypeImpl implements MessageServicePortType {

    public GetMessageResponse getMessage(GetMessageRequest body) {
        GetMessageResponse response = new GetMessageResponse();
        response.setGreeting("Hello " + body.getUserName() + "! How is the weather in the " + body.getUserCity() + "?");
        return response;
    }

}
