package hofls.com.github.hello;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(classes = Application.class)
@ActiveProfiles("junit")
@Testcontainers
abstract class BaseTest {

    @Container
    static final RabbitMQContainer container = new RabbitMQContainer("rabbitmq:3-management");

    @DynamicPropertySource
    static void dynamicRabbitParams(DynamicPropertyRegistry registry) {
        container.start();
        registry.add("spring.rabbitmq.host", container::getHost);
        registry.add("spring.rabbitmq.port", () -> container.getMappedPort(5672));
        registry.add("spring.rabbitmq.username", container::getAdminUsername);
        registry.add("spring.rabbitmq.password", container::getAdminPassword);
    }
}