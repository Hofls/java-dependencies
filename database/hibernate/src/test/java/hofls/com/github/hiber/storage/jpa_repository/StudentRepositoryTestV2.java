package hofls.com.github.hiber.storage.jpa_repository;

import hofls.com.github.hiber.storage.junit.BaseWithTransaction;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.test.context.jdbc.Sql;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRepositoryTestV2 extends BaseWithTransaction {

    @Resource
    private StudentRepository studentRepository;

    @Test
    @Sql("student/delete_test.sql")
    public void delete_test() throws IOException {
        assertEquals(1, studentRepository.findAll().size());
        studentRepository.deleteByName("Mannie");
        assertEquals(0, studentRepository.findAll().size());
    }

    @Test
    @Sql("student/findByCampus_test.sql")
    public void findByCampus_test() throws IOException {
        Student expectedStudentA = studentRepository.findById(234L).get();
        List<Student> actualStudentsA = studentRepository.findByCampusId(569L);
        assertEquals(Arrays.asList(expectedStudentA), actualStudentsA);

        Student expectedStudentB = studentRepository.findById(546L).get();
        List<Student> actualStudentsB = studentRepository.findByCampusId(984L);
        assertEquals(Arrays.asList(expectedStudentB), actualStudentsB);
    }

    @Test
    @Sql("student/findByCampus_test.sql")
    public void findByCampusIds_test() throws IOException {
        Student expectedStudentA = studentRepository.findById(234L).get();
        List<Student> actualStudents = studentRepository.findByCampusIdIn(Arrays.asList(569L, 333L));
        assertEquals(Arrays.asList(expectedStudentA), actualStudents);
    }

    @Test
    @Sql("student/findAll_test.sql")
    public void findAll_test() {
        Page<Student> studentsA = studentRepository.findAll(PageRequest.of(0, 1));
        assertEquals(1, studentsA.getSize());
        assertEquals(2, studentsA.getTotalPages());
        assertEquals(234, studentsA.getContent().get(0).getId());

        Page<Student> studentsB = studentRepository.findAll(PageRequest.of(1, 1));
        assertEquals(1, studentsB.getSize());
        assertEquals(2, studentsB.getTotalPages());
        assertEquals(546, studentsB.getContent().get(0).getId());
    }

    @Test
    @Sql("student/findAll_test.sql")
    public void sliceAll_test() {
        Slice<Student> studentsA = studentRepository.findBy(PageRequest.of(0, 1));
        assertEquals(1, studentsA.getSize());
        assertEquals(234, studentsA.getContent().get(0).getId());

        Slice<Student> studentsB = studentRepository.findBy(PageRequest.of(1, 1));
        assertEquals(1, studentsB.getSize());
        assertEquals(546, studentsB.getContent().get(0).getId());
    }

    @Test
    @Sql("student/findBadBoys_test.sql")
    public void findNativeIn() throws IOException {
        Student expectedStudent = studentRepository.findById(546L).get();
        assertEquals(Arrays.asList(expectedStudent), studentRepository.findNativeIn(null));
        assertEquals(Arrays.asList(expectedStudent), studentRepository.findNativeIn(new ArrayList<>()));
        assertEquals(Arrays.asList(expectedStudent), studentRepository.findNativeIn(Arrays.asList(546L, 782L)));
    }

    @Test
    @Sql("student/findBadBoys_test.sql")
    public void findIn() throws IOException {
        Student expectedStudent = studentRepository.findById(546L).get();
        assertEquals(Arrays.asList(expectedStudent), studentRepository.findIn(null));
        // works for PostgreSQL, because of COALESCE:
        // assertEquals(Arrays.asList(expectedStudent), studentRepository.findIn(new ArrayList<>()));
        assertEquals(Arrays.asList(expectedStudent), studentRepository.findIn(Arrays.asList(546L, 782L)));
    }

    @Test
    @Sql("student/findBadBoys_test.sql")
    public void findBadBoys2_test() {
        Student expectedStudent = studentRepository.findById(546L).get();
        List<Student> actual = studentRepository.findNonNativeIn("Satan", "Hell");
        assertEquals(Arrays.asList(expectedStudent), actual);
    }

    @Test
    @Sql("student/findBadBoys_test.sql")
    public void findBadBoys3_test() {
        Student object = new Student(3L, "Satan", null);
        Student expectedStudent = studentRepository.findById(546L).get();
        List<Student> actual = studentRepository.objectAsParameter(object);
        assertEquals(Arrays.asList(expectedStudent), actual);
    }

    @Test
    public void findCustomBoys_test() {
        List<Student> actual = studentRepository.findCustomBoys();
        assertEquals("John", actual.get(0).getName());
    }

    @Test
    @Sql("student/findAll_test.sql")
    public void findMapCustomNative_test() {
        List<ICustomStudent> actual = studentRepository.findMapCustomNative();
        assertEquals(2, actual.size());
        assertEquals("Helga", actual.get(0).getName());
    }

    @Test
    @Sql("student/findAll_test.sql")
    public void findMapCustom_test() {
        List<ICustomStudent> actual = studentRepository.findMapCustom();
        assertEquals(2, actual.size());
        assertEquals("Helga", actual.get(0).getName());
    }

    @Test
    @Sql("student/findAll_test.sql")
    public void findNotJohn_test() {
        List<Student> actual = studentRepository.findNotJohn(PageRequest.of(1, 1));
        assertEquals(1, actual.size());
    }

    @Test
    @Sql("student/findAll_test.sql")
    public void nonNativeJoinExample() {
        List<Student> actual = studentRepository.nonNativeJoinExample();
        assertEquals(2, actual.size());
        assertEquals("Helga", actual.get(0).getName());
    }

}
