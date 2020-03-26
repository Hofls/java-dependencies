package hofls.com.github;

import hofls.com.github.annotation.PostgresDataJpaTest;
import hofls.com.github.domain.Person;
import hofls.com.github.domain.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@PostgresDataJpaTest
public class SpringDataJpaAnnotationTest {

	@Autowired
	private PersonRepository personRepository;

	@Test
	@Sql("testEmbeddedDatabase.sql")
	public void testEmbeddedDatabase() {
		Optional<Person> personOptional = personRepository.findById(1L);

		assertThat(personOptional).hasValueSatisfying(person -> {
			assertThat(person.getId()).isNotNull();
			assertThat(person.getFirstName()).isEqualTo("Dave");
			assertThat(person.getLastName()).isEqualTo("Syer");
		});
	}
}
