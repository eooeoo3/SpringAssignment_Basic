package com.sparta.todoapp.service;

import com.sparta.todoapp.controller.TodoRequestDTO;
import com.sparta.todoapp.repository.Todo;
import com.sparta.todoapp.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;
    public Todo createTodo(TodoRequestDTO dto){
        var newTodo = dto.toEntity();
        return todoRepository.save(newTodo);
    }
}
