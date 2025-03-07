package com.example.api.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "codemed", nullable = false)
    private Medecin medecin;

    @ManyToOne
    @JoinColumn(name = "codepat", nullable = false)
    private Patient patient;

    @Temporal(TemporalType.DATE)
    private Date date;
}
