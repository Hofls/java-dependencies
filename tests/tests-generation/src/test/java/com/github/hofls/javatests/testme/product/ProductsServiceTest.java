package com.github.hofls.javatests.testme.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.mockito.Mockito.*;

class ProductsServiceTest {
    @Mock
    ProductsRepository productsRepository;
    @InjectMocks
    ProductsService productsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCalculateProducts() {
        // sidenote - it works a bit better with constructor
        when(productsRepository.findProducts(anyLong())).thenReturn(Arrays.<Product>asList(new Product()));

        String result = productsService.calculateProducts(Long.valueOf(1));
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme