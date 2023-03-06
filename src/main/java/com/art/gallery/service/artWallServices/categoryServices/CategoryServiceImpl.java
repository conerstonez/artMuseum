package com.art.gallery.service.artWallServices.categoryServices;

import com.art.gallery.model.data.Category;
import com.art.gallery.model.dto.request.CategoryDto;
import com.art.gallery.model.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
        this.mapper = new ModelMapper();
    }


    @Override
    public Category saveCategory(CategoryDto categoryDto) {
        Category category = mapper.map(categoryDto, Category.class);
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long categoryId) {
        Category category = categoryRepository.getReferenceById(categoryId);
        CategoryDto categoryDto = mapper.map(category, CategoryDto.class);
        return categoryRepository.save(mapper.map(categoryDto, Category.class));
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryRepository.findCategoryByName(categoryName);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(String categoryName) {
        categoryRepository.delete(getCategoryByName(categoryName));
    }
}
