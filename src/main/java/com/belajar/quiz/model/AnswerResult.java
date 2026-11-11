package com.belajar.quiz.model;

public class AnswerResult {
    private boolean correct;
    private String correctOption;

    public AnswerResult(boolean correct, String correctOption) {
        this.correct = correct;
        this.correctOption = correctOption;
    }

    public boolean isCorrect() {return correct;}
    public String isCorrectOption() {return correctOption;}
}
