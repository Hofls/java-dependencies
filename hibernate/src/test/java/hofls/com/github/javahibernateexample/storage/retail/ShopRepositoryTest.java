package hofls.com.github.javahibernateexample.storage.retail;

import hofls.com.github.javahibernateexample.storage.JpaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { JpaConfig.class })
@Transactional
public class ShopRepositoryTest {

    @Resource
    private ShopRepository shopRepository;


    @Test
    public void create_read_test() {
        Shop shop = new Shop();
        shop.setName("Potato shop");
        shopRepository.save(shop);

        List<Shop> shops = shopRepository.findAll(new FindShopsSpecification());

        assertEquals(1, shops.size());
        assertEquals("Potato shop", shops.get(0).getName());
    }


}
