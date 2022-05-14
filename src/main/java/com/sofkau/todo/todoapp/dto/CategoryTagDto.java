package com.sofkau.todo.todoapp.dto;

import lombok.Data;

@Data
public class CategoryTagDto {

    private Long id;
    private String categoryTag;
    private Long noteId;
}
