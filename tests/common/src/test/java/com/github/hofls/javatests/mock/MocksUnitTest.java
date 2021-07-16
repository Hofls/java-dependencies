package com.github.hofls.javatests.mock;

import com.github.hofls.javatests.unit.Mathematics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MocksUnitTest {

    @Mock
    private SalaryExternalService salaryExternalService;

    @InjectMocks
    private SalaryComponent salaryCalculator;

    @Test
    public void should_get_monthly_salary() {
        when(salaryExternalService.findDailySalary()).thenReturn(1000L);
        assertEquals(30000, salaryCalculator.getMonthlySalary());
    }

    @Test
    public void should_update_salary() {
        salaryCalculator.updateSalary(60000L);
        verify(salaryExternalService, times(1)).updateDailySalary(2000L);
    }

    @Test
    public void should_call_update_with_daily_salary() {
        salaryCalculator.updateSalary(60000L);

        ArgumentCaptor<Long> argument = ArgumentCaptor.forClass(Long.class);
        verify(salaryExternalService).updateDailySalary(argument.capture());
        assertEquals(2000L, argument.getValue());
    }

    @Test
    public void void_should_throw_exception() {
        doThrow(new RuntimeException("Wrong salary")).when(salaryExternalService).updateDailySalary(any());

        Exception expectedException = Assertions.assertThrows(RuntimeException.class, () -> {
            salaryCalculator.updateSalary(60000L);
        });
        assertEquals("Wrong salary", expectedException.getMessage());
    }

}
