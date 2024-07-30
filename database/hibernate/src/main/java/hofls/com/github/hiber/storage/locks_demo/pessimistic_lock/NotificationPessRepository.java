package hofls.com.github.hiber.storage.locks_demo.pessimistic_lock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.util.UUID;


public interface NotificationPessRepository extends JpaRepository<NotificationPess, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    NotificationPess findById(long id);

    @Query(nativeQuery = true, value =
        "SELECT np.* FROM notification_pess np" +
        "WHERE np.id = :id FOR UPDATE")
    NotificationPess lockById(@Param(value = "id") UUID id);

}
