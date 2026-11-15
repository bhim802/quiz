package com.belajar.quiz.controller;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belajar.quiz.model.AnswerRequest;
import com.belajar.quiz.model.AnswerResult;
import com.belajar.quiz.model.QuestionResponse;
import com.belajar.quiz.service.QuestionService;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<QuestionResponse> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    public QuestionResponse getById(@PathVariable Long id) {
        return questionService.getById(id);
    }

    @PostMapping("/{id}/answer")
    public AnswerResult answer(@PathVariable Long id, @Valid @RequestBody AnswerRequest request) {
        return questionService.checkAnswer(id, request.getSelectedOption());
    }
}