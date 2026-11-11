package com.belajar.quiz.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.belajar.quiz.model.AnswerResult;
import com.belajar.quiz.model.Question;

@Service
public class QuestionService {
    private final List<Question> questions = new ArrayList<>(Arrays.asList(
            new Question(1L, "Apa bahasa Inggris dari 'kucing'?", "Dog", "Cat", "Bird", "Fish", "B"),
            new Question(2L, "Apa bahasa Inggris dari 'makan'?", "Eat", "Drink", "Sleep", "Run", "A")));

    public List<Question> getAll() {
        return questions;
    }

    public Question getById(Long id) {
        return questions.stream()
                .filter(q -> q.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Soal tidak ditemukan"));
    }

    public AnswerResult checkAnswer(Long id, String selectedOption) {
        Question q = getById(id);
        boolean correct = q.getCorrectOption().equalsIgnoreCase(selectedOption);
        return new AnswerResult(correct, q.getCorrectOption());
    }
}