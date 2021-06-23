package hofls.com.github.h2db.locks_demo.pessimistic_lock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;


public interface NotificationPessRepository extends JpaRepository<NotificationPess, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    NotificationPess findById(long id);
}
