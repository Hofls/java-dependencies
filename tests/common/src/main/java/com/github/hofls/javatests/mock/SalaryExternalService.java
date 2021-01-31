package com.github.hofls.javatests.mock;

import org.springframework.stereotype.Service;

@Service
public class SalaryExternalService {

    public Long findDailySalary() {
        return 0L; // request to some external service
    }

    public void updateDailySalary(long dailySalary) {
        // request to some external service
    }
}
