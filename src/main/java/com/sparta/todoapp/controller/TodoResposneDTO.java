package com.sparta.todoapp.controller;

import com.sparta.todoapp.repository.Todo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TodoResposneDTO {
    private Long todoId;
    private String title;
    private String content;
    private String userName;
    private LocalDateTime createAT;

    public TodoResposneDTO(Todo todo){
        this.todoId = todo.getTodoId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.userName = todo.getUserName();
        this.createAT = todo.getCreateAt();
    }
}
