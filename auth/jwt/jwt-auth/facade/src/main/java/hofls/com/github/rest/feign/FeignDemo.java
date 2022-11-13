package hofls.com.github.rest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "mirror-service", url = "http://localhost:8080/")
public interface FeignDemo {

    @PostMapping(value = "/demo")
    String feignEndpoint();

}
