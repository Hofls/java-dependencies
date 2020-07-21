package hofls.com.github.javahibernateexample.storage.university;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootApplication(scanBasePackages = {"hofls.com.github.javahibernateexample"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class StudentRepositoryTestV2 {

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
    @Sql("student/findBadBoys_test.sql")
    public void findBadBoys_test() throws IOException {
        Student expectedStudent = studentRepository.findById(546L).get();
        assertEquals(Arrays.asList(expectedStudent), studentRepository.findBadBoys());
    }

}
