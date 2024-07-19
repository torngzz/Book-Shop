package com.aub.e_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aub.e_shop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
