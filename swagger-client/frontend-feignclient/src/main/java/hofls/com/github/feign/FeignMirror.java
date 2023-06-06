package hofls.com.github.feign;

import hofls.com.github.exception.CustomExceptionConfig;
import hofls.com.github.rest.mirror.IMirror;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "mirror-service", url = "http://localhost:8080/", configuration = CustomExceptionConfig.class)
public interface FeignMirror extends IMirror {
}
