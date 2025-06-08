package com.flipstyle.product.service;

import com.flipstyle.product.Exception.CategoryNotFoundException;
import com.flipstyle.product.dto.ProductDTO;
import com.flipstyle.product.entity.Category;
import com.flipstyle.product.entity.Product;
import com.flipstyle.product.mapper.ProductMapper;
import com.flipstyle.product.repository.CategoryRepository;
import com.flipstyle.product.repository.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    //create product

    public ProductDTO createProduct(ProductDTO productDTO){

        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category id "+productDTO.getCategoryId()+"  not found!"));

        //DTO -> entity
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);

        //entity -> DTO
        return ProductMapper.toProductDTO(product);

    }
    //get all products

    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();

    }
    //get product by id

    public ProductDTO getProductById(Long id){
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        return ProductMapper.toProductDTO(product);
    }

    //Update Product

    public ProductDTO updateProduct(Long id, ProductDTO productDTO){
        Product product = productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found"));

        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()->new RuntimeException("Category not found"));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    //delete product

    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Product " +" id deleted";
    }


}
