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
    List<Student> findByCampusIdIn(List<Long> campuses);
    // List<StudentMovementEvent> findFirstByStudentIdOrderByEventTimeDesc(UUID studentId);

    // Page is Slice with total count (makes extra count(*) query)
    // Also includes sort/order
    Page<Student> findAll(Pageable pageable);
    Slice<Student> findBy(Pageable page);
    @Query("select s from Student s where s.name <> 'John'")
    List<Student> findNotJohn(Pageable page);


    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.at-query
    // Pretty limited, for full power of SQL use "nativeQuery = true"
    @Query("select s from Student s where s.name = 'Satan' and s.campus.name = 'Hell'")
    List<Student> findNonNativeIn();
    @Query("select s from Student s where s.name = :personName and s.campus.name = :campusName")
    List<Student> findNonNativeIn(String personName, String campusName);
    @Query("select s from Student s where s.name = :#{#stud.name}")
    List<Student> objectAsParameter(Student stud);
    @Query( "select s from Student s " +
            " inner join Campus c on c.id = s.campus.id" +
            " where c.name is not null")
    List<Student> nonNativeJoinExample();
    @Query(value = "SELECT s FROM Student s WHERE COALESCE(:studentIds) is null OR s.id IN (:studentIds) ")
    List<Student> findIn(@Param("studentIds") List<Long> studentIds);
    @Query("select s from Student s where :status is null OR s.status = :status")
    List<Student> findByEnum(@Param("status") Status status);
    @Query("select s from Student s where (:statuses) is null OR s.status IN (:statuses)")
    List<Student> findByEnums(@Param("statuses") List<Status> statuses);

    // Unlimited SQL (with subqueries, SQL functions, etc)
    // Warning! To check for null in a lot of types (e.g. boolean), you have to use list and send empty list instead of null
    @Query(nativeQuery = true, value = "SELECT * FROM student WHERE :studentIds is null OR id IN (:studentIds) ")
    List<Student> findNativeIn(@Param("studentIds") List<Long> studentIds);
    @Query(nativeQuery = true, value = "select * from student where :status is null OR status = CAST(:status AS text)")
    List<Student> findNativeByEnum(@Param("status") Status status);
    @Query(nativeQuery = true, value = "select * from student where (:statuses) is null OR status IN (:statuses)")
    List<Student> findNativeByEnums(@Param("statuses") List<String> statuses); // yep, no normal enum lists;

    // Mixed:
    /** Select custom fields */
    @Query(nativeQuery = true, value = "SELECT 133 as id, 'John' as name, null as campus_id, null as status FROM DUAL")
    List<Student> findCustomBoys();
    /** Map results to any interface (native) */
    @Query(nativeQuery = true, value = "SELECT s.name FROM student s")
    List<ICustomStudent> findMapCustomNative();
    /** Map results to any interface (non-native) */
    @Query(value = "SELECT s.name as name FROM Student s")
    List<ICustomStudent> findMapCustom();
    /** Rare case when you need to update only specific field, to prevent overriding other fields (parallel editing) */
    @Modifying
    @Query("UPDATE Student s SET s.name = ?1 WHERE s.id = ?2")
    void updateName(String name, Long id);

}
