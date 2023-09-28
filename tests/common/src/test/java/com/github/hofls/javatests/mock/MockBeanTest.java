package com.github.hofls.javatests.mock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MockBeanTest {

    /**
     * @MockBean replaces real bean with mock that does nothing
     * Try to change annotation to @Autowired, see what happens
     */
    @MockBean // Warning! Spring reloads context for each test with @Mockbean. Use all those annotations in one class (e.g. in Application.java)
    private SalaryExternalService salaryExternalService;

    @Autowired
    private SalaryComponent salaryCalculator;

    @Test
    public void should_get_monthly_salary() {
        assertEquals(0, salaryCalculator.getMonthlySalary());
    }

    @Test
    public void should_update_salary() {
        salaryCalculator.updateSalary(60000L);
    }

}
