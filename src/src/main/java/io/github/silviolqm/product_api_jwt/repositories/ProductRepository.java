package io.github.silviolqm.product_api_jwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.silviolqm.product_api_jwt.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
