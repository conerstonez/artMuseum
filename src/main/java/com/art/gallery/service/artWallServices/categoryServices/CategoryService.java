package com.art.gallery.service.artWallServices.categoryServices;

import com.art.gallery.model.data.Category;
import com.art.gallery.model.dto.request.CategoryDto;

import java.util.List;

public interface CategoryService {
    Category saveCategory(CategoryDto category);
    Category updateCategory(Long categoryId);
    Category getCategoryByName(String categoryName);
    List<Category> getAllCategories();
    void deleteCategory(String categoryName);
}
