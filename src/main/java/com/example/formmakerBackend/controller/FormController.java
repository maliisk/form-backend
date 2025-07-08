package com.example.formmakerBackend.controller;

import com.example.formmakerBackend.entity.Form;
import com.example.formmakerBackend.repository.FormRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/forms")
@CrossOrigin(origins = "http://localhost:5173")
public class FormController {
    @Autowired
    private FormRepository formRepository;

    @PostMapping
    public Form saveForm(@RequestBody Map<String, Object> payload) throws JsonProcessingException {
        String title = (String) payload.get("title");
        String json = new ObjectMapper().writeValueAsString(payload.get("formElements"));

        Form form = new Form();
        form.setTitle(title);
        form.setJsonStructure(json);
        return formRepository.save(form);
    }

    @GetMapping
    public List<Form> getAllForms() {
        return formRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Form> getFormById(@PathVariable Long id) {
        return formRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteForm(@PathVariable Long id) {
        if (!formRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        formRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}

