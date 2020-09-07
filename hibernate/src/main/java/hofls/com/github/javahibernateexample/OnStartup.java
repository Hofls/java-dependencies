package hofls.com.github.javahibernateexample;

import hofls.com.github.javahibernateexample.storage.jpa_repository.Student;
import hofls.com.github.javahibernateexample.storage.jpa_repository.StudentRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Component
@Transactional
public class OnStartup {

    @Resource
    private StudentRepository studentRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        Student newStudent = new Student();
        newStudent.setName("Helga");
        studentRepository.save(newStudent);

        for (Student student : studentRepository.findAll()) {
            System.out.println("Database integration is working! " + student);
        }
    }

}
