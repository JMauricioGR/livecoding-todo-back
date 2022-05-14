package com.sofkau.todo.todoapp.service;

import com.sofkau.todo.todoapp.dto.Mapper;
import com.sofkau.todo.todoapp.dto.NoteDto;
import com.sofkau.todo.todoapp.entity.CategoryTag;
import com.sofkau.todo.todoapp.repository.CategoryTagRepository;
import com.sofkau.todo.todoapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    private CategoryTagRepository  categoryTagRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public NoteDto createNote(NoteDto noteDto) {
        return mapper.fromEntityToNoteDto(noteRepository.save(mapper.fromNoteDtoToEntity(noteDto)));
    }

    @Override
    public NoteDto updateNote(NoteDto noteDto) {
        return mapper.fromEntityToNoteDto(noteRepository.save(mapper.fromNoteDtoToEntity(noteDto)));
    }

    @Override
    public void deleteNote(Long id) {
        List<CategoryTag> categoryTags = categoryTagRepository.findByNoteId(id);
        if(categoryTags.size() > 0){
            categoryTags.forEach(tagsToDelete -> categoryTagRepository.deleteById(tagsToDelete.getId()));
        }
        noteRepository.deleteById(id);
    }
}
