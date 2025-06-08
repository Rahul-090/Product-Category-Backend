package com.flipstyle.product.service;

import com.flipstyle.product.Exception.CategoryAlreadyExistsException;
import com.flipstyle.product.dto.CategoryDTO;
import com.flipstyle.product.entity.Category;
import com.flipstyle.product.mapper.CategoryMapper;
import com.flipstyle.product.repository.CategoryRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // create category

    public CategoryDTO createCategory(CategoryDTO categoryDTO){

        Optional<Category> optionalCategory = categoryRepository.findByName(categoryDTO.getName());
        if(optionalCategory.isPresent()){
            throw new CategoryAlreadyExistsException("Category "+categoryDTO.getName()+" already exist");
        }
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);

    }

    //get all categories

    public List<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll().stream().map(CategoryMapper :: toCategoryDTO).toList();
    }

    //get category ny id

    public CategoryDTO getCategoryById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
        return CategoryMapper.toCategoryDTO(category);
    }

    //delete category

    public String deleteCategory(Long id){
        categoryRepository.deleteById(id);
        return "Category "+id+" has been deleted!";
    }

}
