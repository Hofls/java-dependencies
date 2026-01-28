package hofls.com.github.hiber.storage.fields.demo;

import hofls.com.github.hiber.storage.junit.BaseWithTransaction;
import org.junit.jupiter.api.Test;

import jakarta.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FieldsDemoTest extends BaseWithTransaction {

    @Resource
    private FieldsDemoRepository repository;

    @Test
    void create_read_test() {
        FieldsDemo fields = new FieldsDemo();
        fields.setMessageStatus(MessageStatus.DONE);
        fields.setMessageId("3k3ffd-3kfdskj-fdskxxc-dkfmk3");

        repository.save(fields);

        FieldsDemo actual = repository.findAll().get(0);
        assertEquals(MessageStatus.DONE, actual.getMessageStatus());
    }

}