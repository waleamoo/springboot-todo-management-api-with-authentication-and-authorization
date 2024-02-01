package com.techqwerty.todomanagement.service;

import java.util.List;

import com.techqwerty.todomanagement.dto.TodoDto;

public interface TodoService {
    TodoDto addTodo(TodoDto todo);
    TodoDto getTodo(Long id);
    List<TodoDto> getAllTodos();
    TodoDto updateTodo(TodoDto todoDto, Long id);
    void deleteTodo(Long id);
    TodoDto completeTodo(Long id);
    TodoDto inCompleteTodo(Long id);

}
