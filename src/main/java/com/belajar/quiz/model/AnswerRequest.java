package com.belajar.quiz.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class AnswerRequest {

    @NotBlank(message = "selectedOption wajib diisi")
    @Pattern(regexp = "^[A-Da-d]$", message = "selectedOption harus A, B, C, atau D")
    private String selectedOption;

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }
}