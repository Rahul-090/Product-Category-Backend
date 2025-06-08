package com.flipstyle.product.controller;

import com.flipstyle.product.dto.ProductDTO;
import com.flipstyle.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(
        name="Product REST API CRUD operation",
        description = "CREATE, READ, UPDATE and DELETE operations on PRODUCT"
)
@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private  ProductService productService;

    //getAllProduct
    @Operation(
            summary = "Fetch all the available products",
            description = "REST API to fetch all products"
    )
    @GetMapping
    public List<ProductDTO> getAllProduct(){
        return  productService.getAllProducts();
    }
    //createProduct
    @Operation(
            summary = "Create new products",
            description = "REST API to create new product"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
            ProductDTO createdProduct =  productService.createProduct(productDTO);
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    //updateProduct
    @Operation(
            summary = "Update product",
            description = "REST API to update product"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id,  @RequestBody ProductDTO productDTO){
                return productService.updateProduct(id, productDTO);
    }

    //get Product by id
    @Operation(
            summary = "Fetch product By ID",
            description = "REST API to fetch product by ID"
    )
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    //delete product
    @Operation(
            summary = "Delete product By ID",
            description = "REST API to fetch product by ID"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
            return productService.deleteProduct(id);
    }

}
