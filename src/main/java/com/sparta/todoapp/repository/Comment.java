package com.sparta.todoapp.repository;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    private Long commentId;

    @Column(nullable = false)//null값 허용 x
    private String content;

    @Column(nullable = false)
    private String userName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = false)
    private Todo todo;

    private LocalDateTime createdAt;

    @Builder
    public Comment(String content, String userName, Todo todo) {
        this.content = content;
        this.userName = userName;
        this.todo = todo;
        this.createdAt = LocalDateTime.now();
    }
    public void updateContent(String content) {
        this.content = content;
    }

}
