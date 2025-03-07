package com.example.api.service;

import com.example.api.model.Medecin;
import com.example.api.repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedecinService {

    @Autowired
    private MedecinRepository repository;

    public List<Medecin> getAll() {
        return repository.findAll();
    }

    public Optional<Medecin> getById(Long id) {
        return repository.findById(id);
    }

    public Medecin save(Medecin medecin) {
        return repository.save(medecin);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
