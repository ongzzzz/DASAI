package com.example.xiyouji.quiz.service;

import com.example.xiyouji.quiz.vo.Quiz;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface QuizSelector {

    List<Quiz> selectQuiz(List<Quiz> quizzes, Integer num);
}
