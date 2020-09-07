package hofls.com.github.javahibernateexample.storage.specification;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

        predicates.add(root.get("name").in(shopName));

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

}
