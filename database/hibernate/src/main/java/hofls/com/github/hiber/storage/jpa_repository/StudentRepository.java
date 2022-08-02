package hofls.com.github.hiber.storage.jpa_repository;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@JaversSpringDataAuditable
public interface StudentRepository extends JpaRepository<Student, Long> {

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.limit-query-result
    void deleteByName(String name);
    List<Student> findByName(String name);
    List<Student> findByCampus(Campus campus);
    List<Student> findByCampusId(Long campusId);

    // Page is Slice with total count (makes extra count(*) query)
    Page<Student> findAll(Pageable pageable);
    Slice<Student> findBy(Pageable page);


    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.at-query
    // Very limited, for full power of SQL use "nativeQuery = true"
    @Query("select s from Student s where s.name = 'Satan' and s.campus.name = 'Hell'")
    List<Student> findBadBoys();
    @Query("select s from Student s where s.name = :personName and s.campus.name = :campusName")
    List<Student> findBadBoys(String personName, String campusName);
    // Unlimited SQL (with joins, subqueries, SQL functions, etc)
    @Query(nativeQuery = true, value = "SELECT * FROM student WHERE id IN :studentIds")
    List<Student> findBadBoys(@Param("studentIds") List<Long> studentIds);

    /** Rare case when you need to update only specific field, to prevent overriding other fields (parallel editing) */
    @Modifying
    @Query("UPDATE Student s SET s.name = ?1 WHERE s.id = ?2")
    void updateName(String name, Long id);

}
