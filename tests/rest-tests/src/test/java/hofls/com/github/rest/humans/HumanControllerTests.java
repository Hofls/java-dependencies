package hofls.com.github.rest.humans;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HumanControllerTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void check_empty_endpoint() throws Exception {
        WebTestClient
            .bindToServer()
                .baseUrl("http://localhost:8080")
                .build()
                .get()
                .uri("/people/empty")
            .exchange()
                .expectStatus().isOk()
                .expectBody().isEmpty();
    }



}
