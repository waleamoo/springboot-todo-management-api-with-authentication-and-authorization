package com.techqwerty.todomanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techqwerty.todomanagement.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
