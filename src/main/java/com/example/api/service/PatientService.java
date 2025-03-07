package com.example.api.service;

import com.example.api.model.Patient;
import com.example.api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public List<Patient> getAll() {
        return repository.findAll();
    }

    public Optional<Patient> getById(Long id) {
        return repository.findById(id);
    }

    public Patient save(Patient patient) {
        return repository.save(patient);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
