package hofls.com.github;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface FoodRepository extends JpaRepository<Food, Long> {
}
