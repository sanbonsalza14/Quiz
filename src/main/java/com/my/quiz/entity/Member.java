package com.my.quiz.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.Query;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String name;
    private int age;
    private String address;
}
