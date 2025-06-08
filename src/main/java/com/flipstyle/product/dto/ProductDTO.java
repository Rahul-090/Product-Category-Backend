package com.flipstyle.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Schema(
        name="Product",
        description = "It holds  products"
)
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long CategoryId;

    public ProductDTO(Long id, String name, String description, Double price, Long categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        CategoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Long categoryId) {
        CategoryId = categoryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(CategoryId, that.CategoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, CategoryId);
    }
}
