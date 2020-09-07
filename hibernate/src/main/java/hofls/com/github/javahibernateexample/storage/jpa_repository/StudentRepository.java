package hofls.com.github.javahibernateexample.storage.jpa_repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    void deleteByName(String name);
    List<Student> findByName(String name);
    List<Student> findByCampus(Campus campus);
    List<Student> findByCampusId(Long campusId);
    Page<Student> findAll(Pageable pageable);

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.at-query
    @Query("select s from Student s where s.name = 'Satan' and s.campus.name = 'Hell'")
    List<Student> findBadBoys();

}
