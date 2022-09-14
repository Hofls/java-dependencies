package hofls.com.github.hiber.storage.specification;


import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

@AllArgsConstructor
public class SubquerySpecification implements Specification<Employee> {

    private String name;

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        // Returns IDS of employees that work at shop with specific name
        Subquery<Long> subquery = criteriaQuery.subquery(Long.class);
        Root<Employee> subRoot = subquery.from(Employee.class);
        subquery.select(subRoot.get(Employee_.ID));
        Join<Employee, Shop> shopJoin = subRoot.join(Employee_.SHOP, JoinType.LEFT);
        Predicate shopHasName = criteriaBuilder.equal(shopJoin.get(Shop_.NAME), name);
        subquery.where(shopHasName);

        // Finds employees by IDS
        return root.get("id").in(subquery);
    }

}
