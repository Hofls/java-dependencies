package hofls.com.github.liqui;

import hofls.com.github.liqui.storage.university.Student;
import hofls.com.github.liqui.storage.university.StudentRepository;
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
        newStudent.setFirstName("Helga");
        studentRepository.save(newStudent);

        for (Student student : studentRepository.findAll()) {
            System.out.println("Database integration is working! " + student);
        }
    }

}
