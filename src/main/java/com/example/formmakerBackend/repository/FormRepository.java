package com.example.formmakerBackend.repository;

import com.example.formmakerBackend.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {}

