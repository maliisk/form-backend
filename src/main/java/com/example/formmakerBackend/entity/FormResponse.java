package com.example.formmakerBackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
public class FormResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Form form;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public String getJsonAnswer() {
        return jsonAnswer;
    }

    public void setJsonAnswer(String jsonAnswer) {
        this.jsonAnswer = jsonAnswer;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    @Lob
    private String jsonAnswer; // Form cevapları da JSON

    private LocalDateTime submittedAt = LocalDateTime.now();
}

