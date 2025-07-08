package com.example.formmakerBackend.controller;

import com.example.formmakerBackend.entity.Form;
import com.example.formmakerBackend.entity.FormResponse;
import com.example.formmakerBackend.repository.FormRepository;
import com.example.formmakerBackend.repository.FormResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/responses")
@CrossOrigin(origins = "http://localhost:5173")
public class FormResponseController {
    @Autowired
    private FormResponseRepository responseRepo;
    @Autowired private FormRepository formRepo;

    @PostMapping("/{formId}")
    public FormResponse submitResponse(@PathVariable Long formId, @RequestBody String jsonAnswer) {
        Form form = formRepo.findById(formId).orElseThrow();
        FormResponse response = new FormResponse();
        response.setForm(form);
        response.setJsonAnswer(jsonAnswer);
        return responseRepo.save(response);
    }

    @GetMapping("/{formId}")
    public List<FormResponse> getResponses(@PathVariable Long formId) {
        return responseRepo.findByFormId(formId);
    }
}

