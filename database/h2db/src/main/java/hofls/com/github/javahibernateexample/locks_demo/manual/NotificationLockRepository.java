package hofls.com.github.javahibernateexample.locks_demo.manual;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationLockRepository extends JpaRepository<NotificationLock, Long> {

}
