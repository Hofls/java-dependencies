package hofls.com.github.hiber.storage.json;

import hofls.com.github.hiber.storage.junit.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TrelloCardRepositoryTest extends BaseTest {

    @Resource
    private TrelloCardRepository repository;


    @Test
    public void create_read_test() {
        TrelloCard.Info info = new TrelloCard.Info();
        info.setText("Implement scrum");
        info.setStatus("In process");
        info.setPriority(4L);
        info.setComments(Arrays.asList("Hey", "Ho", "Let's", "Go"));

        TrelloCard card = new TrelloCard();
        card.setInfo(info);

        repository.save(card);

        TrelloCard actualCard = repository.findAll().get(0);
        assertEquals("In process", actualCard.getInfo().getStatus());
    }


}
