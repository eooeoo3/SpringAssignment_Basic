package com.sparta.todoapp.controller;

import com.sparta.todoapp.repository.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentResponseDTO {
    private Long commentId;
    private String content;
    private String userName;
    private Long todoId;
    private LocalDateTime createdAt;

    public CommentResponseDTO(Comment comment) {
        this.commentId = comment.getCommentId();
        this.content = comment.getContent();
        this.userName = comment.getUserName();
        this.todoId = comment.getTodo().getTodoId();
        this.createdAt = comment.getCreatedAt();
    }
}
