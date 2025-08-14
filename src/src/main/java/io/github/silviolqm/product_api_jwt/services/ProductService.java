package io.github.silviolqm.product_api_jwt.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.github.silviolqm.product_api_jwt.dtos.ProductRequestDTO;
import io.github.silviolqm.product_api_jwt.dtos.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    
    List<ProductResponseDTO> getAllProducts();
    Page<ProductResponseDTO> getAllProducts(Pageable pageable);
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO createProduct(ProductRequestDTO product);
    ProductResponseDTO updateProduct(Long id, ProductRequestDTO product);
    void deleteProduct(Long id);
}