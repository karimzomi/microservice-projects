package com.internaut.internaut_ms.entities;

import com.internaut.internaut_ms.enums.TrancheAge;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Internaut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInternaut;
    private String identifiant;
    private TrancheAge trancheAge;

}
