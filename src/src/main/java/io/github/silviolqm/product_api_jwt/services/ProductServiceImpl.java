package io.github.silviolqm.product_api_jwt.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.silviolqm.product_api_jwt.dtos.ProductRequestDTO;
import io.github.silviolqm.product_api_jwt.dtos.ProductResponseDTO;
import io.github.silviolqm.product_api_jwt.entities.Product;
import io.github.silviolqm.product_api_jwt.exceptions.ProductNotFoundException;
import io.github.silviolqm.product_api_jwt.repositories.ProductRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> ProductResponseDTO.from(product))
                .toList();
    }

    @Override
    public Page<ProductResponseDTO> getAllProducts(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(product -> ProductResponseDTO.from(product));
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("Produto com id " + id + " não encontrado"));
        return ProductResponseDTO.from(product);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO product) {
        Product newProduct = product.toProduct();
        productRepository.save(newProduct);
        return ProductResponseDTO.from(newProduct);
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO product) {
        Product existingProduct = productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("Produto com id " + id + " não encontrado"));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        productRepository.save(existingProduct);
        return ProductResponseDTO.from(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
