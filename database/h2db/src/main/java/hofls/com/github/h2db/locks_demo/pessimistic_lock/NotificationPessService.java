package hofls.com.github.h2db.locks_demo.pessimistic_lock;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationPessService {

    @Autowired
    private NotificationPessRepository notificationRepository;

    @Transactional
    public long createNotification() {
        val notification = new NotificationPess();
        notification.setStatus("NEW");
        return notificationRepository.save(notification).getId();
    }

    @Transactional
    public void pessimisticLock(long id) {
        try {
            val notification = notificationRepository.findById(id);
            if ("LOCKED".equals(notification.getStatus())) {
                throw new RuntimeException("Already locked!");
            }
            Thread.sleep(50); // some delay, just like in real situation

            notification.setStatus("LOCKED");
            notificationRepository.save(notification);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
