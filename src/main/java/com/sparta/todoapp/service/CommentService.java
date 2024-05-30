package com.sparta.todoapp.service;

import com.sparta.todoapp.controller.CommentRequestDTO;
import com.sparta.todoapp.repository.Comment;
import com.sparta.todoapp.repository.CommentRepository;
import com.sparta.todoapp.repository.Todo;
import com.sparta.todoapp.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;

    public Comment createComment(CommentRequestDTO dto) {
        Todo todo = todoRepository.findById(dto.getTodoId())
                .orElseThrow(() -> new IllegalArgumentException("일자가 선택되지 않았습니다."));

        if (dto.getContent() == null || dto.getContent().isEmpty()) {
            throw new IllegalArgumentException("댓글 입력창이 비었습니다.");
        }

        Comment comment = Comment.builder()
                .content(dto.getContent())
                .userName(dto.getUserName())
                .todo(todo)
                .build();

        return commentRepository.save(comment);
    }
    public Comment updateComment(Long commentId, CommentRequestDTO dto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 존재하지 않습니다."));

        if (dto.getContent() == null || dto.getContent().isEmpty()) {
            throw new IllegalArgumentException("댓글 내용이 비어있습니다.");
        }

        if (!comment.getUserName().equals(dto.getUserName())) {
            throw new IllegalArgumentException("댓글 작성자가 일치하지 않습니다.");
        }

        comment.updateContent(dto.getContent());

        return commentRepository.save(comment);
    }
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 존재하지 않습니다."));

        commentRepository.delete(comment);
    }



}
