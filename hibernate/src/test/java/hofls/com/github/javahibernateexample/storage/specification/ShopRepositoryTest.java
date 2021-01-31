package hofls.com.github.javahibernateexample.storage.specification;

import hofls.com.github.javahibernateexample.storage.junit.BaseTest;
import org.junit.Test;
import org.springframework.data.jpa.domain.Specification;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ShopRepositoryTest extends BaseTest {

    @Resource
    private ShopRepository shopRepository;


    @Test
    public void single_specification() {
        Shop shop = new Shop();
        shop.setName("Potato shop");
        shopRepository.save(shop);

        List<Shop> shops = shopRepository.findAll(new FindShopsSpecification("Potato shop"));

        assertEquals(1, shops.size());
        assertEquals("Potato shop", shops.get(0).getName());
    }

    @Test
    public void multiple_specifications() {
        Shop bananaShop = new Shop();
        bananaShop.setName("Banana shop");
        shopRepository.save(bananaShop);

        Shop tomatoShop = new Shop();
        tomatoShop.setName("Tomato shop");
        shopRepository.save(tomatoShop);

        FindShopsSpecification bananaSpec = new FindShopsSpecification("Banana shop");
        FindShopsSpecification tomatoSpec = new FindShopsSpecification("Tomato shop");
        Specification<Shop> combinedSpec = Specification.where(bananaSpec).or(tomatoSpec);
        List<Shop> shops = shopRepository.findAll(combinedSpec);

        assertEquals(2, shops.size());
        assertEquals("Banana shop", shops.get(0).getName());
        assertEquals("Tomato shop", shops.get(1).getName());
    }

}
