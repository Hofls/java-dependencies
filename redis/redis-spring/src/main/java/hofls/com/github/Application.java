package hofls.com.github;

import hofls.com.github.redis.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
public class Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);

		LOGGER.info("Sending message...");
		template.convertAndSend("chat", "Hello from Redis!");
		Thread.sleep(1500L);
		System.exit(0);
	}
}
