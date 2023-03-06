package com.art.gallery.service.artWallServices.categoryServices;

import com.art.gallery.model.data.Category;
import com.art.gallery.model.dto.request.CategoryDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createCategoryTest(){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setDescription("test description");
        categoryDto.setName("test name");

        Category category  = categoryService.saveCategory(categoryDto);
        assertEquals(1, categoryService.getAllCategories().size());
    }

    @Test
    void categoryUpdateTest(){
        Category category = categoryService.getCategoryByName("test name");


    }
}