package com.fintech.api;

import com.fintech.domain.ProductService;
import com.fintech.dto.ProductDTO;
import com.fintech.model.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void testGetAllProducts() throws Exception {
        when(productService.getAllProducts()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/api/products"))
               .andExpect(status().isOk());
    }

    @Test
    public void testGetProductById() throws Exception {
        ProductDTO productDTO = new ProductDTO(1L, "Product 1", 100.0, 10, "Category 1");
        when(productService.getProductById(1L)).thenReturn(productDTO);
        mockMvc.perform(get("/api/products/1"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$").exists());
    }

    @Test
    public void testCreateProduct() throws Exception {
        ProductDTO productDTO = new ProductDTO(null, "New Product", 50.0, 5, "New Category");
        when(productService.createProduct(any(ProductDTO.class))).thenReturn(productDTO);
        mockMvc.perform(post("/api/products")
               .contentType(MediaType.APPLICATION_JSON)
               .content("{\"name\":\"New Product\",\"price\":50.0,\"stock\":5,\"category\":\"New Category\"}"))
               .andExpect(status().isCreated())
               .andExpect(jsonPath("$").exists());
    }

    @Test
    public void testUpdateProduct() throws Exception {
        ProductDTO productDTO = new ProductDTO(1L, "Updated Product", 75.0, 7, "Updated Category");
        when(productService.updateProduct(1L, any(ProductDTO.class))).thenReturn(productDTO);
        mockMvc.perform(put("/api/products/1")
               .contentType(MediaType.APPLICATION_JSON)
               .content("{\"name\":\"Updated Product\",\"price\":75.0,\"stock\":7,\"category\":\"Updated Category\"}"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$").exists());
    }

    @Test
    public void testDeleteProduct() throws Exception {
        Mockito.doNothing().when(productService).deleteProduct(1L);
        mockMvc.perform(delete("/api/products/1"))
               .andExpect(status().isNoContent());
    }
}