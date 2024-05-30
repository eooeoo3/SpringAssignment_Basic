package com.sparta.todoapp.controller;

import com.sparta.todoapp.repository.Comment;
import com.sparta.todoapp.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1.0/comment/")
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDTO> postComment(@RequestBody CommentRequestDTO dto) {
        Comment comment = commentService.createComment(dto);
        CommentResponseDTO response = new CommentResponseDTO(comment);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/{commentId}")
    public ResponseEntity<CommentResponseDTO> putComment(@PathVariable Long commentId, @RequestBody CommentRequestDTO dto) {
        Comment comment = commentService.updateComment(commentId, dto);
        CommentResponseDTO response = new CommentResponseDTO(comment);
        return ResponseEntity.ok().body(response);
    }
    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok().body("댓글이 삭제되었습니다.");
    }


}
