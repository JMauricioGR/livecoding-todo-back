package com.sofkau.todo.todoapp.dto;

import com.sofkau.todo.todoapp.entity.Category;
import com.sofkau.todo.todoapp.entity.CategoryTag;
import com.sofkau.todo.todoapp.entity.Note;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {

    public Note fromNoteDtoToEntity(NoteDto noteDto){
        Note note = new Note();
        note.setCategoryId(noteDto.getCategoryId());
        note.setDone(noteDto.isDone());
        note.setMessage(noteDto.getMessage());
        note.setId(noteDto.getId());
        List<CategoryTag> categoryTags = new ArrayList<>();
        if(noteDto.getCategoryTagDto().size() > 0){
            noteDto.getCategoryTagDto().forEach(categoryTagDto -> categoryTags.add(this.fromCategoryTagDtoToEntity(categoryTagDto)));
            note.setCategoryTags(categoryTags);
        }
        return note;
    }

    public NoteDto fromEntityToNoteDto(Note note){
        NoteDto noteDto = new NoteDto();
        noteDto.setCategoryId(note.getCategoryId());
        noteDto.setDone(note.isDone());
        noteDto.setMessage(note.getMessage());
        noteDto.setId(note.getId());
        List<CategoryTagDto> categoryTagDto = new ArrayList<>();
        note.getCategoryTags().forEach(categoryTag -> categoryTagDto.add(this.fromEntityToCategoryTagDto(categoryTag)));
        noteDto.setCategoryTagDto(categoryTagDto);
        return noteDto;
    }

    public Category fromCategoryDtoToEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setTitle(categoryDto.getTitle());
        List<Note> notes = new ArrayList<>();
        if(categoryDto.getNotes().size() > 0){
            categoryDto.getNotes().forEach(noteDto -> notes.add(this.fromNoteDtoToEntity(noteDto)));
            category.setNotes(notes);
        }
        return category;
    }

    public CategoryDto fromEntityToCategoryDto(Category category){
        List<NoteDto> notes = new ArrayList<>();
        category.getNotes().forEach(note -> notes.add(this.fromEntityToNoteDto(note)));
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setTitle(category.getTitle());
        categoryDto.setNotes(notes);
        return categoryDto;
    }

    public CategoryTag fromCategoryTagDtoToEntity(CategoryTagDto categoryTagDto){
        CategoryTag categoryTag = new CategoryTag();
        categoryTag.setId(categoryTagDto.getId());
        categoryTag.setCategoryTag(categoryTagDto.getCategoryTag());
        categoryTag.setNoteId(categoryTagDto.getNoteId());
        return categoryTag;
    }

    public CategoryTagDto fromEntityToCategoryTagDto(CategoryTag categoryTag){
        CategoryTagDto categoryTagDto = new CategoryTagDto();
        categoryTagDto.setCategoryTag(categoryTag.getCategoryTag());
        categoryTagDto.setId(categoryTag.getId());
        categoryTagDto.setNoteId(categoryTag.getNoteId());
        return categoryTagDto;
    }
}
