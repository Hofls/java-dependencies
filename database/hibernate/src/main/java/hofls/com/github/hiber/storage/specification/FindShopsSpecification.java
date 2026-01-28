package hofls.com.github.hiber.storage.specification;


import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class FindShopsSpecification implements Specification<Shop> {

    private String shopName;

    public FindShopsSpecification(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public Predicate toPredicate(Root<Shop> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();

        predicates.add(root.get(Shop_.NAME).in(shopName));

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

}
