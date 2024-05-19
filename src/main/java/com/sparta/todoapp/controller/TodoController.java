package com.sparta.todoapp.controller;

import com.sparta.todoapp.repository.Todo;
import com.sparta.todoapp.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TodoController {

    public final TodoService todoService;
    @PostMapping("/v1.0/todo")
    public ResponseEntity<TodoResposneDTO> postTodo(@RequestBody TodoRequestDTO dto){
        Todo todo = todoService.createTodo(dto);
        TodoResposneDTO response = new TodoResposneDTO(todo);
        return ResponseEntity.ok().body(response);
    }
}
