package com.sofkau.todo.todoapp.service;

import com.sofkau.todo.todoapp.dto.CategoryTagDto;
import com.sofkau.todo.todoapp.dto.Mapper;
import com.sofkau.todo.todoapp.repository.CategoryTagRepository;
import com.sofkau.todo.todoapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryTagServiceImpl implements CategoryTagService{

    @Autowired
    private CategoryTagRepository categoryTagRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public CategoryTagDto createCategoryTag(CategoryTagDto categoryTagDto) {
        return mapper.fromEntityToCategoryTagDto(categoryTagRepository.save(mapper.fromCategoryTagDtoToEntity(categoryTagDto)));
    }

    @Override
    public CategoryTagDto updateCategoryTag(CategoryTagDto categoryTagDto) {
        return mapper.fromEntityToCategoryTagDto(categoryTagRepository.save(mapper.fromCategoryTagDtoToEntity(categoryTagDto)));
    }

    @Override
    public void deleteCategoryTag(Long id) {
        categoryTagRepository.deleteById(id);
    }
}
