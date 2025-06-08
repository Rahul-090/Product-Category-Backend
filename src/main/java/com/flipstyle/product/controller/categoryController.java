package com.flipstyle.product.controller;

import com.flipstyle.product.Exception.CategoryAlreadyExistsException;
import com.flipstyle.product.dto.CategoryDTO;
import com.flipstyle.product.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name="Category REST API CRUD operation",
        description = "CREATE, READ, UPDATE and DELETE operations on CATEGORY"
)
@RestController
@RequestMapping("/api/categories")
public class categoryController {

    @Autowired
    private CategoryService categoryService;

    //get all categories
    @Operation(
            summary = "Fetch all the available categories",
            description = "REST API to fetch all categories"
    )
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
            return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.FOUND);
    }


    //create category
    @Operation(
            summary = "Create new category",
            description = "REST API to create new category"
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
            CategoryDTO savedCategory  = categoryService.createCategory(categoryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
//        try{
//            CategoryDTO savedCategory  = categoryService.createCategory(categoryDTO);
//            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
//        }catch(CategoryAlreadyExistsException ex) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
//        }
//        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);

    }

    //get category by id
    @Operation(
            summary = "Fetch category By ID",
            description = "REST API to fetch category by ID"
    )
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    //delete category

    @Operation(
            summary = "Delete category",
            description = "REST API to Delete category"
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public String  deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }


}
