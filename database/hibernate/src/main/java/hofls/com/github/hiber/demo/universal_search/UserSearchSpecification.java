package hofls.com.github.hiber.demo.universal_search;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UserSearchSpecification implements Specification<User> {

    private final UserSearchDto searchDto;

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();

        if (searchDto.getName() != null) {
            predicates.add(criteriaBuilder.equal(root.get(User_.NAME), searchDto.getName()));
        }

        if (searchDto.getStatuses() != null) {
            predicates.add(root.get(User_.STATUS).in(searchDto.getStatuses()));
        }

        if (searchDto.getRegisteredAfter() != null) {
            predicates.add(criteriaBuilder.greaterThan(root.get(User_.REGISTRATION_DATE), searchDto.getRegisteredAfter()));
        }

        if (searchDto.getHasPoints()) {
            predicates.add(root.get(User_.POINTS).isNotNull());
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

}
