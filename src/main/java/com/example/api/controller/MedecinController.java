package com.example.api.controller;

import com.example.api.model.Medecin;
import com.example.api.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medecins")
public class MedecinController {

    @Autowired
    private MedecinService service;

    @GetMapping
    public List<Medecin> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Medecin> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Medecin create(@RequestBody Medecin medecin) {
        return service.save(medecin);
    }

    @PutMapping("/{id}")
    public Medecin update(@PathVariable Long id, @RequestBody Medecin medecin) {
        medecin.setCodemed(id);
        return service.save(medecin);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
