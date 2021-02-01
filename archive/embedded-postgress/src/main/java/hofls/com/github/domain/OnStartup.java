package hofls.com.github.domain;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Component
@Transactional
public class OnStartup {

    @Resource
    private PersonRepository personRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        Person newStudent = new Person();
        newStudent.setFirstName("Helga");
        newStudent.setLastName("fdsfsd");
        personRepository.save(newStudent);

        for (Person student : personRepository.findAll()) {
            System.out.println("Database integration is working! " + student);
        }
    }

}
