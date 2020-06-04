package hofls.com.github.dependency.injection;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RatingServiceTest {

    @Autowired
    private RatingService ratingServiceUnderTest;

    @Test
    public void testFindRatings() {
        final List<Rating> ratings = ratingServiceUnderTest.findRatings();

        assertEquals(2, ratings.size());
        assertEquals(1, ratings.get(0).getRating());
        assertEquals(5, ratings.get(1).getRating());
    }
}
