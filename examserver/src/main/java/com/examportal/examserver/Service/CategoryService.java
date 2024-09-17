package com.examportal.examserver.Service;

import com.examportal.examserver.Model.Exam.Category;

import java.util.Set;

public interface CategoryService {

    public Category addCategory(Category category);

    public Category getCategoryById(Long id);

    public Set<Category> getAllCategory();

    public Category updateCategory( Category category);

    public void deleteCategoryById(Long id);
}
