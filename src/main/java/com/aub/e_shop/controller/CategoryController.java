package com.aub.e_shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aub.e_shop.model.Category;
import com.aub.e_shop.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getAllCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories"; // Thymeleaf template for listing categories
    }

    @GetMapping("/getById{id}")
    public String getCategoryById(@PathVariable("id") Long id, Model model) 
    {
        Optional<Category> category = categoryService.getCategoryById(id);
        model.addAttribute("category", category.orElse(new Category()));
        return "categories-view-form"; // Thymeleaf template for viewing a single category
    }
    
}
