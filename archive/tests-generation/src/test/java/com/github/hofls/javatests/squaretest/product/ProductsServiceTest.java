package com.github.hofls.javatests.squaretest.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class ProductsServiceTest {

    @Mock
    private ProductsRepository mockProductsRepository;

    private ProductsService productsServiceUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        productsServiceUnderTest = new ProductsService(mockProductsRepository);
    }

    @Test
    void testCalculateProducts() {
        // Setup

        // Configure ProductsRepository.findProducts(...).
        final Product product = new Product();
        product.setId(0L);
        product.setType("type");
        final List<Product> products = Arrays.asList(product);
        when(mockProductsRepository.findProducts(0L)).thenReturn(products);

        // Run the test
        final String result = productsServiceUnderTest.calculateProducts(0L);

        // Verify the results
        assertEquals("result", result);
    }
}
