package com.github.hofls.feign;

import com.github.hofls.exception.CustomExceptionConfig;
import com.github.hofls.rest.mirror.IMirror;
import org.springframework.cloud.openfeign.FeignClient;

// Localhost alternative - http://hofls.requestcatcher.com/
@FeignClient(name = "mirror-service", url = "http://localhost:8080/", configuration = CustomExceptionConfig.class)
public interface FeignMirror extends IMirror {
}
