package hofls.com.github.hiber.demo.unversal_search;

import hofls.com.github.hiber.storage.junit.BaseWithTransaction;
import hofls.com.github.hiber.demo.universal_search.User;
import hofls.com.github.hiber.demo.universal_search.UserRepository;
import hofls.com.github.hiber.demo.universal_search.UserSearchDto;
import hofls.com.github.hiber.demo.universal_search.UserSearchSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserSearchSpecificationTest extends BaseWithTransaction {

    @Resource
    private UserRepository userRepository;

    @Test
    public void multiple_predicates() {
        // Init
        fillTableWithData();

        // Query, result
        UserSearchDto searchDto = new UserSearchDto();
        searchDto.setName("John Vick");
        searchDto.setStatuses(Arrays.asList("EMPTY", "COMPLETE"));
        searchDto.setRegisteredAfter(LocalDate.of(2021, 11, 28));
        searchDto.setHasPoints(true);

        Pageable pageable = PageRequest.of(0, 10);
        UserSearchSpecification specification = new UserSearchSpecification(searchDto);
        Page<User> usersPage = userRepository.findAll(specification, pageable);

        // Assertions
        assertEquals(1, usersPage.getContent().size());
        assertEquals("John Vick", usersPage.getContent().get(0).getName());
    }

    private void fillTableWithData() {
        // DB init
        User userA = new User();
        userA.setName("John Vick");
        userA.setStatus("COMPLETE");
        userA.setRegistrationDate(LocalDate.of(2022, 11, 28));
        userA.setPoints(23L);
        userRepository.save(userA);

        User userB = new User();
        userB.setName("Sally Lost");
        userRepository.save(userB);
    }

}
