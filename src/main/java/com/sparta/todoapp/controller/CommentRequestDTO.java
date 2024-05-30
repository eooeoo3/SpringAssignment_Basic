package com.sparta.todoapp.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDTO {
    private String content;
    private String userName;
    private Long todoId;
}
