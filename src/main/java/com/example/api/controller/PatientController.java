package com.example.api.controller;

import com.example.api.model.Patient;
import com.example.api.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService service;

    @GetMapping
    public List<Patient> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Patient> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Patient create(@RequestBody Patient patient) {
        return service.save(patient);
    }

    @PutMapping("/{id}")
    public Patient update(@PathVariable Long id, @RequestBody Patient patient) {
        patient.setCodepat(id);
        return service.save(patient);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
