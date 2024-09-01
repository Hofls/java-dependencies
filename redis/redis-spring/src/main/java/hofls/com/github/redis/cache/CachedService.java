package hofls.com.github.redis.cache;

import hofls.com.github.redis.pubsub.purchase.PurchasePublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CachedService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchasePublisher.class);

    @Cacheable(value = "products", key = "#id")
    public String getProductById(String id) {
        LOGGER.info("getProductById should be called only once, because second call will get value from cache (redis)");
        return "Product Name " + id;
    }

}
