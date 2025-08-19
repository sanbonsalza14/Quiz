package com.my.quiz.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
@Table(name = "Quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content; //내용
    @Column(nullable = false, length = 1)
    private String answer;  //O/X
    @Column(nullable = false, length = 255)
    private String Writer;  //작성자 이메일
}
