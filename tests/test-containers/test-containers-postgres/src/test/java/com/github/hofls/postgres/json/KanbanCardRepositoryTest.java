package com.github.hofls.postgres.json;

import com.github.hofls.postgres.BaseTest;
import com.github.hofls.postgres.json.parameters.IParameters;
import com.github.hofls.postgres.json.parameters.ObjectMapperUtils;
import com.github.hofls.postgres.json.parameters.ParametersA;
import com.github.hofls.postgres.json.parameters.ParametersUtils;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import jakarta.annotation.Resource;

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
        card.setParameters(ObjectMapperUtils.toJsonNode(new ParametersA("12.45.55.77", "8080")));

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

    @Test
    @Sql("student/protocols.sql")
    public void protocols_test() throws IOException {
        KanbanCard actualCard = repository.findAll().get(0);
        assertEquals("[SMTP, FTP]", actualCard.getProtocols().toString());
    }


}
