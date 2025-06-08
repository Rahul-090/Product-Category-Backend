package com.flipstyle.product.mapper;

import com.flipstyle.product.dto.CategoryDTO;
import com.flipstyle.product.dto.ProductDTO;
import com.flipstyle.product.entity.Category;
import com.flipstyle.product.entity.Product;

public class ProductMapper {
    //entity toProductDTO

    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }

    //DTO to entity
    public static Product toProductEntity(ProductDTO productDTO, Category category){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        return product;
    }
}
