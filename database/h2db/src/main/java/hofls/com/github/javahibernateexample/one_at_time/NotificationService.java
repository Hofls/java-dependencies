package hofls.com.github.javahibernateexample.one_at_time;

import lombok.val;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class NotificationService {

    @Resource
    private NotificationRepository notificationRepository;

    @Resource
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
