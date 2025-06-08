package com.flipstyle.product.service;

import com.flipstyle.product.dto.CategoryDTO;
import com.flipstyle.product.entity.Category;
import com.flipstyle.product.repository.CategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    private Category category;
    private CategoryDTO categoryDTO;

    @BeforeEach
    void setUp() {
        category = new Category();
        category.setId(1L);
        category.setName("test");
        categoryDTO.setId(1L);
        categoryDTO = new CategoryDTO();
        categoryDTO.setName("test");

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createCategory_categoryShouldbeCreated() {
        when(categoryRepository.findByName(categoryDTO.getName())).thenReturn(java.util.Optional.empty());
        when(categoryRepository.save(any(Category.class))).thenReturn(category);
        CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
        assertNotNull(savedCategory);
        assertEquals(categoryDTO.getName(), savedCategory.getName());
    }

    @Test
    void getAllCategories() {
    }

    @Test
    void getCategoryById() {
    }

    @Test
    void deleteCategory() {
    }
}