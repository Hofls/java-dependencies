package hofls.com.github.dependency.injection;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private final List<Rating> ratings;

    public RatingService(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Rating> findRatings() {
        return ratings;
    }

}
