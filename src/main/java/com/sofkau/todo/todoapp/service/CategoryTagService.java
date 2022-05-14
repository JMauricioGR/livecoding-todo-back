package com.sofkau.todo.todoapp.service;

import com.sofkau.todo.todoapp.dto.CategoryTagDto;

public interface CategoryTagService {

    CategoryTagDto createCategoryTag(CategoryTagDto categoryTagDto);

    CategoryTagDto updateCategoryTag(CategoryTagDto categoryTagDto);

    void deleteCategoryTag(Long id);
}
