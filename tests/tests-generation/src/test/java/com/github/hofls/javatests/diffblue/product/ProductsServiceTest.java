package com.github.hofls.javatests.diffblue.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProductsServiceTest {
    @Test
    public void testCalculateProducts() {
        assertEquals("Nothing", (new ProductsService(new ProductsRepository())).calculateProducts(1L));
        assertEquals("Nothing", (new ProductsService(new ProductsRepository())).calculateProducts(0L));
    }
}

