package hofls.com.github.hello;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.RabbitMQContainer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("junit")
abstract class BaseTest {

    private static RabbitMQContainer container;

    @DynamicPropertySource
    static void dynamicRabbitParams(DynamicPropertyRegistry registry) {
        container =  new RabbitMQContainer("rabbitmq:3-management");
        container.start();

        registry.add("spring.rabbitmq.host", container::getHost);
        registry.add("spring.rabbitmq.port", () -> container.getMappedPort(5672));
        registry.add("spring.rabbitmq.username", container::getAdminUsername);
        registry.add("spring.rabbitmq.password", container::getAdminPassword);
    }

}

