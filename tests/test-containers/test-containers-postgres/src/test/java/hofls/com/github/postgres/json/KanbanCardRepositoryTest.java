package hofls.com.github.postgres.json;



import hofls.com.github.postgres.BaseTest;
import hofls.com.github.postgres.json.parameters.IParameters;
import hofls.com.github.postgres.json.parameters.ParametersA;
import hofls.com.github.postgres.json.parameters.ParametersUtils;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import javax.annotation.Resource;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KanbanCardRepositoryTest extends BaseTest {

    @Resource
    private KanbanRepository repository;


    @Test
    public void create_read_test() {
        KanbanCard.Info info = new KanbanCard.Info();
        info.setText("Implement scrum");
        info.setStatus("In process");
        info.setPriority(4L);
        info.setComments(Arrays.asList("Hey", "Ho", "Let's", "Go"));

        KanbanCard card = new KanbanCard();
        card.setInfo(info);

        repository.save(card);

        KanbanCard actualCard = repository.findAll().get(0);
        assertEquals("In process", actualCard.getInfo().getStatus());
    }

    @Test
    public void parameters_test() {
        KanbanCard card = new KanbanCard();
        card.setCardType(KanbanCard.CardType.TYPE_A);
        card.setParameters(new ParametersA("12.45.55.77", "8080"));

        repository.save(card);

        KanbanCard actualCard = repository.findAll().get(0);
        IParameters actualParams = ParametersUtils.extractParameters(actualCard);
        assertEquals("ParametersA(ip=12.45.55.77, port=8080)", actualParams.toString());
    }

    @Test
    @Sql("student/parameters_b_test.sql")
    public void parameters_b_test() throws IOException {
        KanbanCard actualCard = repository.findAll().get(0);
        IParameters actualParams = ParametersUtils.extractParameters(actualCard);
        assertEquals("ParametersB(description=Hello!, room=23)", actualParams.toString());
    }


}
