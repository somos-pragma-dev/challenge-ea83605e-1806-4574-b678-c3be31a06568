package com.fintech.domain;

import com.fintech.dto.ProductDTO;
import com.fintech.infrastructure.ProductRepository;
import com.fintech.model.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void testGetAllProducts() {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());
        List<ProductDTO> products = productService.getAllProducts();
        assertEquals(0, products.size());
    }

    @Test
    public void testGetProductById() {
        Product product = new Product(1L, "Product 1", 100.0, 10, "Category 1");
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        ProductDTO productDTO = productService.getProductById(1L);
        assertEquals("Product 1", productDTO.getName());
    }

    @Test
    public void testCreateProduct() {
        ProductDTO productDTO = new ProductDTO(null, "New Product", 50.0, 5, "New Category");
        Product product = new Product(null, "New Product", 50.0, 5, "New Category");
        when(productRepository.findByName("New Product")).thenReturn(Optional.empty());
        when(productRepository.save(product)).thenReturn(product);
        ProductDTO createdProductDTO = productService.createProduct(productDTO);
        assertEquals("New Product", createdProductDTO.getName());
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product(1L, "Product 1", 100.0, 10, "Category 1");
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        ProductDTO productDTO = new ProductDTO(1L, "Updated Product", 75.0, 7, "Updated Category");
        ProductDTO updatedProductDTO = productService.updateProduct(1L, productDTO);
        assertEquals("Updated Product", updatedProductDTO.getName());
    }

    @Test
    public void testDeleteProduct() {
        Product product = new Product(1L, "Product 1", 100.0, 10, "Category 1");
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        productService.deleteProduct(1L);
        Mockito.verify(productRepository, Mockito.times(1)).delete(product);
    }

    @Test
    public void testCreateProductWithNegativePrice() {
        ProductDTO productDTO = new ProductDTO(null, "New Product", -50.0, 5, "New Category");
        assertThrows(ValidationException.class, () -> productService.createProduct(productDTO));
    }

    @Test
    public void testCreateProductWithDuplicateName() {
        ProductDTO productDTO = new ProductDTO(null, "Existing Product", 50.0, 5, "New Category");
        Product existingProduct = new Product(2L, "Existing Product", 100.0, 10, "Category 1");
        when(productRepository.findByName("Existing Product")).thenReturn(Optional.of(existingProduct));
        assertThrows(ValidationException.class, () -> productService.createProduct(productDTO));
    }
}