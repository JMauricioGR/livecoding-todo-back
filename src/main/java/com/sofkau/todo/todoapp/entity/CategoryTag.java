package com.sofkau.todo.todoapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "CategoryTag")
@Table(name= "categoryTag")
@Data
public class CategoryTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoryTag;
    private Long noteId;

}
