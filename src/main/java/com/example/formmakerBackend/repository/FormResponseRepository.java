package com.example.formmakerBackend.repository;

import com.example.formmakerBackend.entity.FormResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormResponseRepository extends JpaRepository<FormResponse, Long> {
    List<FormResponse> findByFormId(Long formId);
}
