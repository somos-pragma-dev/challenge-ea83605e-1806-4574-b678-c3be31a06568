package com.fintech.infrastructure;

import com.fintech.model.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindByName() {
        Product product = new Product(1L, "Product 1", 100.0, 10, "Category 1");
        Mockito.when(productRepository.findByName("Product 1")).thenReturn(Optional.of(product));
        Optional<Product> foundProduct = productRepository.findByName("Product 1");
        assertTrue(foundProduct.isPresent());
        assertEquals("Product 1", foundProduct.get().getName());
    }
}