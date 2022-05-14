package com.sofkau.todo.todoapp.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NoteDto{
    private Long id;
    private String message;
    private boolean done;
    private Long categoryId;
    private List<CategoryTagDto> categoryTagDto = new ArrayList<>();
}
