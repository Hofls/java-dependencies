package hofls.com.github.hiber.storage.specification;


import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PredicateSpecification implements Specification<Shop> {

    @Override
    public Predicate toPredicate(Root<Shop> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicatesA = new ArrayList<>();
        predicatesA.add(root.get(Shop_.NAME).in("Banana shop"));
        predicatesA.add(root.get(Shop_.ID).isNotNull());

        final List<Predicate> predicatesB = new ArrayList<>();
        predicatesB.add(root.get(Shop_.NAME).in("Tomato shop"));
        predicatesB.add(root.get(Shop_.ID).isNotNull());

        Predicate predicateA = criteriaBuilder.and(predicatesA.get(0), predicatesA.get(1));
        Predicate predicateB = criteriaBuilder.and(predicatesB.get(0), predicatesB.get(1));

        return criteriaBuilder.or(predicateA, predicateB);
    }

}
