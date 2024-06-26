import com.mycompany.cache.RedisCache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import redis.clients.jedis.Jedis;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Integration test for Redis-backed cache implementation.
 */
@Testcontainers
class RedisBackedCacheTest {

    @Container
    public GenericContainer<?> redis = new GenericContainer<>(DockerImageName.parse("redis:6-alpine"))
        .withExposedPorts(6379);

    private RedisCache redisCache;

    @BeforeEach
    void setUp() throws Exception {
        Jedis jedis = new Jedis(redis.getHost(), redis.getFirstMappedPort());
        redisCache = new RedisCache(jedis, "test");
    }

    @Test
    void testFindingAnInsertedValue() {
        redisCache.put("right-key", "Hello!");
        Optional<String> foundObject = redisCache.get("right-key", String.class);
        assertEquals("Hello!", foundObject.get());

        Optional<String> nonexistent = redisCache.get("wrong-key", String.class);
        assertFalse(nonexistent.isPresent());
    }

}
