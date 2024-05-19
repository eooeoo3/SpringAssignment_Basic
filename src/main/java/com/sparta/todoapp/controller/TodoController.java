package com.sparta.todoapp.controller;

import com.sparta.todoapp.repository.Todo;
import com.sparta.todoapp.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/v1.0/todo/")
@RestController
@AllArgsConstructor
public class TodoController {

    public final TodoService todoService;
    @PostMapping
    public ResponseEntity<TodoResposneDTO> postTodo(@RequestBody TodoRequestDTO dto){
        Todo todo = todoService.createTodo(dto);
        TodoResposneDTO response = new TodoResposneDTO(todo);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/{todoId}")
    public ResponseEntity<TodoResposneDTO> getTodo(@PathVariable Long todoId){
        Todo todo = todoService.getTodo(todoId);
        TodoResposneDTO response = new TodoResposneDTO(todo);
        return ResponseEntity.ok().body(response);

    }
    @GetMapping
    public ResponseEntity<List<TodoResposneDTO>> getTodos(){
        List<Todo> todos = todoService.getTodos();
        List<TodoResposneDTO> response = todos.stream().map(TodoResposneDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(response);

    }
    @PutMapping("/{todoId}")
    public ResponseEntity<TodoResposneDTO> putTodo(@PathVariable Long todoId, @RequestBody TodoRequestDTO dto) {
        Todo todo = todoService.updateTodo(todoId, dto);
        TodoResposneDTO response = new TodoResposneDTO(todo);
        return ResponseEntity.ok().body(response);
    }

}
