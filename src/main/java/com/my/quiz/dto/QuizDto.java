package com.my.quiz.dto;

import com.my.quiz.entity.Quiz;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
    private Long id;

    @NotBlank(message = "퀴즈 내용은 비워둘 수 없습니다.")
    private String content;

    @Pattern(regexp = "^[ox]$", message = "정답은 O또는 X만 가능합니다.")
    private String answer;  //"o" / "X"

    private String Writer;   //서버에서 세션 이메일로 주입

    public static QuizDto fromEntity(Quiz quiz){
        return new QuizDto(quiz.getId(), quiz.getContent(), quiz.getAnswer(), quiz.getWriter());
    }

    public static Quiz toEntity(QuizDto dto) {
        Quiz quiz = new Quiz();
        quiz.setId(dto.getId());
        quiz.setContent(dto.getContent());
        quiz.setAnswer(dto.getAnswer());
        quiz.setWriter(dto.getWriter());
        return quiz;
    }
}
