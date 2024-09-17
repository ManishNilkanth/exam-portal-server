package com.examportal.examserver.Controller;

import com.examportal.examserver.Model.Exam.Category;
import com.examportal.examserver.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category)
    {
        return categoryService.addCategory(category);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category getCategoryById(@PathVariable Long id)
    {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/")
    public Set<Category> getAllCategories()
    {
       return categoryService.getAllCategory();
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Category updateCategory(@RequestBody Category category)
    {
        return categoryService.updateCategory(category);
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategoryById(@PathVariable Long id)
    {
        categoryService.deleteCategoryById(id);
    }
}
