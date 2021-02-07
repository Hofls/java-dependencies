package hofls.com.github.hello;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.utility.DockerImageName;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("junit")
abstract class BaseTest {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BaseTest.class);
    private static GenericContainer<?> container;

    @DynamicPropertySource
    static void dynamicJdbcUrl(DynamicPropertyRegistry registry) {
        container = new GenericContainer<>(DockerImageName.parse("testcontainers/helloworld:1.1.0"))
                .withExposedPorts(8080, 8081)
                .withLogConsumer(new Slf4jLogConsumer(log));
        container.start();
    }

}

