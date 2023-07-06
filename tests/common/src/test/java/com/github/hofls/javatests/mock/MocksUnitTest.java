package com.github.hofls.javatests.mock;

import com.github.hofls.javatests.unit.Mathematics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

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
        // Also helpful - Mockito.when(client.sendRequest(Mockito.any())).thenThrow(new RuntimeException("Mock error"));
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

        Exception actualException = Assertions.assertThrows(RuntimeException.class, () -> {
            salaryCalculator.updateSalary(60000L);
        });
        String expectedException = "Wrong salary";
        assertEquals(expectedException, actualException.getMessage());
    }

    /* For these methods to work:
    1. Create folder "mockito-extensions" in test resources
    2. Create file "org.mockito.plugins.MockMaker" with content "mock-maker-inline"

    public static void mockUser() {
        var sessionUser = new SessionUser(43434, "John");
        var mock = Mockito.mockStatic(UserUtils.class);
        mock.when(UserUtils::getSessionUser).thenReturn(sessionUser);
    }

    // Example argument - "2022-08-17T15:00"
    // At then end of the test - call mock.close(); (via "try-with-resources")
    public static MockedStatic<LocalDateTime> mockLocalDateTime(String dateTime) {
        MockedStatic<LocalDateTime> mock = Mockito.mockStatic(LocalDateTime.class, Mockito.CALLS_REAL_METHODS);
        LocalDateTime testDateTime = LocalDateTime.parse(dateTime);
        mock.when(LocalDateTime::now).thenReturn(testDateTime);
        return mock;
    }

    */

}
