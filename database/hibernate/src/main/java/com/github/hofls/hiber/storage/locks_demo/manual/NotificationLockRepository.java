package com.github.hofls.hiber.storage.locks_demo.manual;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationLockRepository extends JpaRepository<NotificationLock, Long> {

}
