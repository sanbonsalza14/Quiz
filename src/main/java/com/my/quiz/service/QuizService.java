package com.my.quiz.service;

import com.my.quiz.dto.QuizDto;
import com.my.quiz.entity.PlayResult;
import com.my.quiz.repository.PlayResultRepository;
import com.my.quiz.repository.QuizRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;
    private final PlayResultRepository playResultRepository;
    public List<QuizDto> findAll() {
        return quizRepository.findAll().stream().map(QuizDto::fromEntity).toList();
    }

    public void insert(@Valid QuizDto dto) {
    }

    public QuizDto findOne(Long id) {
    }

    public boolean isOwner(QuizDto dto, String email) {
    }

    public void delete(Long id) {
    }

    public QuizDto pickRandom() {
    }

    public boolean checkAnswer(Long id, String answer, String email) {
    }

    public void updatePreserveWriter(@Valid QuizDto dto) {
    }
}
