package com.art.gallery.model.repository;

import com.art.gallery.model.data.Address;
import com.art.gallery.model.data.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByName(String name);
}
