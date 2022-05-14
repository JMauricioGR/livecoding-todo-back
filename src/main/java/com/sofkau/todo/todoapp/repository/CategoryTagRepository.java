package com.sofkau.todo.todoapp.repository;

import com.sofkau.todo.todoapp.entity.CategoryTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryTagRepository extends JpaRepository<CategoryTag, Long> {
    public List<CategoryTag> findByNoteId(Long noteId);
}
