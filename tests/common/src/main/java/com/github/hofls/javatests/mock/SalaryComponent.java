package com.github.hofls.javatests.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalaryComponent {

    @Autowired
    private SalaryExternalService salaryExternalService;

    public Long getMonthlySalary() {
        return salaryExternalService.findDailySalary() * 30;
    }

    public void updateSalary(Long monthlySalary) {
        salaryExternalService.updateDailySalary(monthlySalary / 30);
    }

}
