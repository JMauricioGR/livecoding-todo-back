package com.sofkau.todo.todoapp.controller;

import com.sofkau.todo.todoapp.dto.CategoryDto;
import com.sofkau.todo.todoapp.dto.CategoryTagDto;
import com.sofkau.todo.todoapp.dto.NoteDto;
import com.sofkau.todo.todoapp.entity.Category;
import com.sofkau.todo.todoapp.entity.CategoryTag;
import com.sofkau.todo.todoapp.service.CategoryService;
import com.sofkau.todo.todoapp.service.CategoryTagService;
import com.sofkau.todo.todoapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class Controller {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private NoteService noteService;

    @Autowired
    private CategoryTagService categoryTagService;

    @GetMapping("get/all/categories")
    public List<CategoryDto> getAllCategories(){
        return categoryService.findAllCategories();
    }

    @PostMapping("save/category")
    public CategoryDto saveCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.createCategory(categoryDto);
    }

    @PostMapping("save/note")
    public NoteDto saveNote(@RequestBody NoteDto note){
        return noteService.createNote(note);
    }

    @PostMapping("save/categorytag")
    public CategoryTagDto saveCategoryTag(@RequestBody CategoryTagDto categoryTagDto){
        return categoryTagService.createCategoryTag(categoryTagDto);
    }

    @PutMapping("update/note")
    public NoteDto updateNote(@RequestBody NoteDto noteDto){
        return noteService.updateNote(noteDto);
    }

    @PutMapping("update/categorytag")
    public CategoryTagDto updateCategoryTag(@RequestBody CategoryTagDto categoryTagDto){
        return categoryTagService.updateCategoryTag(categoryTagDto);
    }

    @DeleteMapping("delete/category/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

    @DeleteMapping("delete/note/{id}")
    public void deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
    }

    @DeleteMapping("delete/categorytag/{id}")
    public void deleteCategoryTag(@PathVariable Long id){
        categoryTagService.deleteCategoryTag(id);
    }
}
