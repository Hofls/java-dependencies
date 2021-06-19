package hofls.com.github.javahibernateexample.locks_demo.optimistic_lock;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class NotificationOptService {

    @Autowired
    private NotificationOptRepository notificationRepository;

    @Transactional
    public long createNotification() {
        val notification = new NotificationOpt();
        notification.setStatus("NEW");
        return notificationRepository.save(notification).getId();
    }

    @Transactional
    public void optimisticLock(long id) {
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
