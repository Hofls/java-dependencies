package hofls.com.github.hiber.storage.specification;

import hofls.com.github.hiber.storage.junit.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PredicateSpecificationTest extends BaseTest {

    @Resource
    private ShopRepository shopRepository;

    @Test
    public void multiple_predicates() {
        Shop bananaShop = new Shop();
        bananaShop.setName("Banana shop");
        shopRepository.save(bananaShop);

        Shop tomatoShop = new Shop();
        tomatoShop.setName("Tomato shop");
        shopRepository.save(tomatoShop);

        List<Shop> shops = shopRepository.findAll(new PredicateSpecification());

        assertEquals(2, shops.size());
        assertEquals("Banana shop", shops.get(0).getName());
        assertEquals("Tomato shop", shops.get(1).getName());
    }

}
