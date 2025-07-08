package com.example.formmakerBackend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJsonStructure() {
        return jsonStructure;
    }

    public void setJsonStructure(String jsonStructure) {
        this.jsonStructure = jsonStructure;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Lob
    private String jsonStructure; // Tüm form yapısını JSON olarak tut

    private LocalDateTime createdAt = LocalDateTime.now();
}
