package hofls.com.github;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ApplicationRunner init(FoodService foodService) {
        return args -> {
            Stream.of("Potato", "Spam", "Salad", "Avocado").forEach(name -> {
                Food food = new Food();
                food.setName(name);
                foodService.saveFood(food);
            });
            foodService.getFoods().forEach(System.out::println);
        };
    }

}
