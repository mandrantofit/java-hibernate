package com.example.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codepat;

    private String nom;
    private String prenom;
    private String sexe;
    private String adresse;
}
