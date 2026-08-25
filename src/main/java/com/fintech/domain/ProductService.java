package com.fintech.domain;

import com.fintech.dto.ProductDTO;
import com.fintech.infrastructure.ProductRepository;
import com.fintech.model.Product;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
               .map(this::convertToDTO)
               .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
               .orElseThrow(() -> new ValidationException("Product not found"));
        return convertToDTO(product);
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Assert.isTrue(productDTO.getPrice() >= 0, "Price must be non-negative");
        if (productRepository.findByName(productDTO.getName()).isPresent()) {
            throw new ValidationException("Product name already exists");
        }
        Product product = convertToEntity(productDTO);
        productRepository.save(product);
        return convertToDTO(product);
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
               .orElseThrow(() -> new ValidationException("Product not found"));
        Assert.isTrue(productDTO.getPrice() >= 0, "Price must be non-negative");
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setCategory(productDTO.getCategory());
        productRepository.save(product);
        return convertToDTO(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
               .orElseThrow(() -> new ValidationException("Product not found"));
        productRepository.delete(product);
    }

    private ProductDTO convertToDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getStock(), product.getCategory());
    }

    private Product convertToEntity(ProductDTO productDTO) {
        return new Product(productDTO.getName(), productDTO.getPrice(), productDTO.getStock(), productDTO.getCategory());
    }
}