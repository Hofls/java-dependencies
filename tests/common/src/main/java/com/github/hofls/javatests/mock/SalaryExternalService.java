package com.github.hofls.javatests.mock;

import org.springframework.stereotype.Service;

@Service
public class SalaryExternalService {

    public Long findDailySalary() {
        throw new RuntimeException("Request timed out"); // request to some external service
    }

    public void updateDailySalary(Long dailySalary) {
        throw new RuntimeException("Request timed out"); // request to some external service
    }

}
