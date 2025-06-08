package com.flipstyle.product.repository;

import com.flipstyle.product.entity.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @DisplayName("Should save and retrieve category by name")
    void testFindByName() {
        Category category = new Category();
        category.setName("Electronics");
        categoryRepository.save(category);

        Optional<Category> found = categoryRepository.findByName("Electronics");
        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Electronics");
    }

    @Test
    @DisplayName("Should return empty when category name does not exist")
    void testFindByNameNotFound() {
        Optional<Category> found = categoryRepository.findByName("NonExistent");
        assertThat(found).isNotPresent();
    }

    @Test
    @DisplayName("Should save and retrieve category by id")
    void testSaveAndFindById() {
        Category category = new Category();
        category.setName("Books");
        Category saved = categoryRepository.save(category);
        Optional<Category> found = categoryRepository.findById(saved.getId());
        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Books");
    }

    @Test
    @DisplayName("Should delete category")
    void testDeleteCategory() {
        Category category = new Category();
        category.setName("Clothing");
        Category saved = categoryRepository.save(category);
        categoryRepository.delete(saved);
        Optional<Category> found = categoryRepository.findById(saved.getId());
        assertThat(found).isNotPresent();
    }
}

