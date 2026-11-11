package com.belajar.quiz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import com.belajar.quiz.model.Question;
import com.belajar.quiz.service.QuestionService;
import com.belajar.quiz.model.AnswerRequest;
import com.belajar.quiz.model.AnswerResult;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable Long id) {
        return questionService.getById(id);

    }

    @PostMapping("/{id}/answer")
    public AnswerResult answer(@PathVariable Long id, @RequestBody AnswerRequest request) {
        return questionService.checkAnswer(id, request.getSelectedOption());
    }
}

