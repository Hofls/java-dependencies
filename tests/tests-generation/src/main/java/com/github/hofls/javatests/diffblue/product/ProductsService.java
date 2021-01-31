package com.github.hofls.javatests.diffblue.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }


    public String calculateProducts(Long param) {
        List<Product> products = productsRepository.findProducts(param);
        if (products == null || products.isEmpty()) {
            return "Nothing";
        }

        for (Product product : products) {
            if ("Sold".equals(product.getType())) {
                return "Some sold";
            }
            if (Objects.equals(777L, product.getId())) {
                return "Found special ID";
            }
        }

        return "Everything is ok";
    }

}
