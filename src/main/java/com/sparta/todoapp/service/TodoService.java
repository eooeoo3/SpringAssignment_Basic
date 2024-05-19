package com.sparta.todoapp.service;

import com.sparta.todoapp.controller.TodoRequestDTO;
import com.sparta.todoapp.repository.Todo;
import com.sparta.todoapp.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;
    public Todo createTodo(TodoRequestDTO dto){
        var newTodo = dto.toEntity();
        return todoRepository.save(newTodo);
    }
    public Todo getTodo(Long todoId){
        return todoRepository.findById(todoId)
        .orElseThrow(() -> new IllegalArgumentException());
    }
    public List<Todo> getTodos(){
        return todoRepository.findAll(Sort.by("createdAt").descending());
    }

    public Todo updateTodo(Long todoId, TodoRequestDTO dto) {
        Todo todo = getTodo(todoId);

        if(todo.getPassword() != null && !Objects.equals(todo.getPassword(),dto.getPassword())){
            throw new IllegalArgumentException();
        }
        todo.setTitle(dto.getTitle());
        todo.setContent(dto.getContent());
        todo.setUserName(dto.getUserName());
        return todoRepository.save(todo);

    }
}
