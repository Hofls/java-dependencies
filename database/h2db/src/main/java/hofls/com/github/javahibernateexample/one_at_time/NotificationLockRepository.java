package hofls.com.github.javahibernateexample.one_at_time;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationLockRepository extends JpaRepository<NotificationLock, Long> {

}
