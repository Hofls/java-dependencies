package hofls.com.github.cache;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CacheableRepositoryTest {

    @Mock
    ExternalService mockedService;

    @Autowired
    CacheableRepository cacheableRepository;

    @Test
    public void cacheable_method_executed_only_once() {
        List<String> expectedList = Arrays.asList("abc", "def");
        when(mockedService.getList()).thenReturn(expectedList);
        cacheableRepository.setExternalService(mockedService);

        verify(mockedService, times(0)).getList();
        for (int i = 0; i < 10; i++) {
            List<String> actualList = cacheableRepository.getCachedList();
            assertEquals(expectedList, actualList);
        }
        verify(mockedService, times(1)).getList();
    }

    @Test
    public void cacheable_method_executed_once_per_parameter() {
        List<String> expectedListA = Arrays.asList("AAA", "def");
        List<String> expectedListB = Arrays.asList("BBB", "def");
        when(mockedService.getListBy(7L)).thenReturn(expectedListA);
        when(mockedService.getListBy(889L)).thenReturn(expectedListB);
        cacheableRepository.setExternalService(mockedService);

        verify(mockedService, times(0)).getListBy(7L);
        verify(mockedService, times(0)).getListBy(889L);
        for (int i = 0; i < 10; i++) {
            List<String> actualListA = cacheableRepository.getCachedListBy(7L);
            assertEquals(expectedListA, actualListA);
            List<String> actualListB = cacheableRepository.getCachedListBy(889L);
            assertEquals(expectedListB, actualListB);
        }
        verify(mockedService, times(1)).getListBy(7L);
        verify(mockedService, times(1)).getListBy(889L);
    }

}
