package io.github.silviolqm.product_api_jwt.dtos;

import io.github.silviolqm.product_api_jwt.entities.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductRequestDTO {
    
    @NotNull
    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
    private String name;

    @Size(min = 1, max = 250, message = "Description must be between 1 and 250 characters")
    private String description;

    private String imageUrl;

    @NotNull
    @Min(value = 0, message = "Price must not be less than zero")
    private Double price;

    public Product toProduct() {
        Product product = Product.builder()
                .name(this.name)
                .description(this.description)
                .imageUrl(this.imageUrl)
                .price(this.price)
                .build();
        return product;
    }
}