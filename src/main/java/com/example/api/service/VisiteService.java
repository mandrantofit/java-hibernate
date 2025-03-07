package com.example.api.service;

import com.example.api.model.Medecin;
import com.example.api.model.Patient;
import com.example.api.model.Visite;
import com.example.api.repository.MedecinRepository;
import com.example.api.repository.PatientRepository;
import com.example.api.repository.VisiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisiteService {
 
    @Autowired
    private VisiteRepository visiteRepository;

    @Autowired
    private MedecinRepository medecinRepository;

    @Autowired
    private PatientRepository patientRepository;

    public List<Visite> getAll() {
        return visiteRepository.findAll();
    }

    public Optional<Visite> getById(Long id) {
        return visiteRepository.findById(id);
    }

    public Visite save(Visite visite) {
        // Charger le medecin et le patient depuis la base
        Medecin medecin = medecinRepository.findById(visite.getMedecin().getCodemed())
                                           .orElseThrow(() -> new RuntimeException("Médecin non trouvé"));
        Patient patient = patientRepository.findById(visite.getPatient().getCodepat())
                                           .orElseThrow(() -> new RuntimeException("Patient non trouvé"));

        // Associer les objets complets
        visite.setMedecin(medecin);
        visite.setPatient(patient);

        return visiteRepository.save(visite);
    }

    public void delete(Long id) {
        visiteRepository.deleteById(id);
    }
}
