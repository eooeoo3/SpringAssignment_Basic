package com.sparta.todoapp.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @PostMapping("/v1.0/todo")
    public ResponseEntity postTodo(){
        return ResponseEntity.ok().build();
    }
}
