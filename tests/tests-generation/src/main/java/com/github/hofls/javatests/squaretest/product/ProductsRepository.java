package com.github.hofls.javatests.squaretest.product;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductsRepository {


    public List<Product> findProducts(Long param) {
        return new ArrayList<>();
    }

}
