package hofls.com.github.javahibernateexample.storage.university;

import hofls.com.github.javahibernateexample.storage.JpaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { JpaConfig.class })
@Transactional
public class StudentRepositoryTest {

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private CampusRepository campusRepository;

    @Test
    public void create_read_test() {
        String name = "John";
        Student student = new Student();
        student.setName(name);
        studentRepository.save(student);

        Student student2 = studentRepository.findAll().get(0);
        assertEquals(name, student2.getName());
    }

    @Test
    public void update_test() {
        String name = "Helga";
        Student student = new Student();
        student.setName(name);
        studentRepository.save(student);

        String newName = "Algeh";
        Student studentB = studentRepository.findByName(name).get(0);
        studentB.setName(newName);
        studentRepository.save(studentB);

        assertEquals(newName, studentRepository.findAll().get(0).getName());
    }

    @Test
    public void delete_test() {
        String name = "Mannie";
        Student student = new Student();
        student.setName(name);
        studentRepository.save(student);
        assertEquals(1, studentRepository.findAll().size());

        studentRepository.deleteByName(name);
        assertEquals(0, studentRepository.findAll().size());
    }


    @Test
    public void findByCampus_test() {
        Campus campus = new Campus();
        campus.setName("Snt Geogre Campus");
        campusRepository.save(campus);

        String name = "John";
        Student studentA = new Student();
        studentA.setName(name);
        studentA.setCampus(campus);
        studentRepository.save(studentA);

        assertEquals(studentA, studentRepository.findByCampus(campus).get(0));
    }

    @Test
    public void findBadBoys_test() {
        Campus campus = new Campus();
        campus.setName("Hell");
        campusRepository.save(campus);

        Student studentA = new Student();
        studentA.setName("Satan");
        studentA.setCampus(campus);
        studentRepository.save(studentA);

        assertEquals(studentA, studentRepository.findBadBoys().get(0));
    }

}
