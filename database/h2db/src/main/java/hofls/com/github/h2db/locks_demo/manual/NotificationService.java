package hofls.com.github.h2db.locks_demo.manual;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationLockRepository notificationLockRepository;

    @Transactional
    public long createNotification() {
        val notification = new Notification();
        notification.setStatus("NEW");
        return notificationRepository.save(notification).getId();
    }

    @Transactional
    public void goodLock(long id) {
        try {
            val notification = notificationRepository.findById(id).get();
            Thread.sleep(50); // some delay, just like in real situation

            val notificationLock = new NotificationLock();
            notificationLock.setNotification(notification);
            notificationLockRepository.save(notificationLock);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Already locked!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /** Doesn't really work (look at tests) */
    @Transactional
    public void badLock(long id) {
        try {
            val notification = notificationRepository.findById(id).get();
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
