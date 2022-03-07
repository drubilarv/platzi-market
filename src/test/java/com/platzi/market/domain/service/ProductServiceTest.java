package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this); // o puede ser this

        product = new Product();
        product.setName("almendras");
        product.setCategoryId(1);
        product.setPrice(3000.0);
        product.setActive(true);
        product.setStock(100);

    }

    @Test
    void getAll() {
        when(productRepository.getAll()).thenReturn(Arrays.asList(product));
        assertNotNull(productService.getAll());
    }

   @Test
    void getProduct_exist() {
        int idProductExist = 50; //cafe
        when(productRepository.getProduct(idProductExist)).thenReturn(Optional.of(product));
        assertNotNull(productService.getProduct(idProductExist));
        assertEquals(Optional.of(product), productService.getProduct(idProductExist));
    }

    @Test
    void getByCaterory() {
        int categoryId=1;
        when(productRepository.getByCategory(categoryId)).thenReturn(Optional.of(Arrays.asList(product)));
        assertNotNull(productService.getByCaterory(categoryId));
        assertEquals(product.getCategoryId(), categoryId);
    }

    @Test
    void save() {
        when(productRepository.save(product)).thenReturn(product);
        assertNotNull(productService.save(product));
        assertEquals(productService.save(product), product);
    }

  /* @Test
    void delete() {
        productRepository.delete(1);
        assertTrue(productService.delete(1));
    }*/





}