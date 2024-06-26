
* Alternative A:
```
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public abstract class RedisTest {

    @DynamicPropertySource
    static void dynamicRedis(DynamicPropertyRegistry registry) {
        var redisContainer = new GenericContainer<>(DockerImageName.parse("redis:6-alpine"))
                .withExposedPorts(6379);
        redisContainer.start();

        registry.add("spring.redis.host", redisContainer::getHost);
        registry.add("spring.redis.port", redisContainer::getFirstMappedPort);
    }

}
```

* Alternative B:
```

<dependency>
    <groupId>com.redis.testcontainers</groupId>
    <artifactId>testcontainers-redis-junit</artifactId>
    <version>1.6.2</version>
    <scope>test</scope>
</dependency>

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public abstract class RedisTest {

    private static RedisContainer redisContainer;

    @DynamicPropertySource
    static void dynamicJdbcUrl(DynamicPropertyRegistry registry) {
        LogManager.getLogManager().getLogger("").setLevel(Level.OFF);
        redisContainer = new RedisContainer(DockerImageName.parse("redis:7.0.0-alpine"));
        redisContainer.start();

        registry.add("spring.redis.host", redisContainer::getHost);
        registry.add("spring.redis.port", redisContainer::getFirstMappedPort);
    }

}

```