package hofls.com.github.feign;

import hofls.com.github.rest.mirror.IMirror;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "mirror-service", url = "http://localhost:8080/")
public interface FeignMirror extends IMirror {
}
