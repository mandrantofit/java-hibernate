package com.example.api.controller;

import com.example.api.model.Visite;
import com.example.api.service.VisiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visites")
public class VisiteController {
    @Autowired
    private VisiteService service;

    @GetMapping
    public List<Visite> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Visite> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Visite create(@RequestBody Visite visite) {
        return service.save(visite);
    }

    @PutMapping("/{id}")
    public Visite update(@PathVariable Long id, @RequestBody Visite visite) {
        visite.setId(id);
        return service.save(visite);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
