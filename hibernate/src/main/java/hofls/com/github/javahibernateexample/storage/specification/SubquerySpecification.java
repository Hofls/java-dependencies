package hofls.com.github.javahibernateexample.storage.specification;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class SubquerySpecification implements Specification<Employee> {

    private String name;

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        // Returns IDS of employees that work at shop with specific name
        Subquery<Long> subquery = criteriaQuery.subquery(Long.class);
        Root<Employee> rootEmployee = subquery.from(Employee.class);
        subquery.select(rootEmployee.get("id"));
        Join<Employee, Shop> shopJoin = rootEmployee.join("shop", JoinType.LEFT);
        Predicate shopHasName = criteriaBuilder.equal(shopJoin.get("name"), name);
        subquery.where(shopHasName);

        // Finds employees by IDS
        return root.get("id").in(subquery);
    }

}
