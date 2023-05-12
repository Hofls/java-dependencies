package hofls.com.github.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@EnableCaching
@Configuration
public class CacheConf{

    @Bean(name = "cacheableRepositoryManager")
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("repository-cache");
    }

    @CacheEvict(allEntries = true, value = "repository-cache")
    @Scheduled(fixedDelay = 30 * 60 * 1000) // Won't work without @EnableScheduling
    public void clearCache() {
        System.out.println("CACHE CLEARED");
    }
}