package com.evenement.evenement_ms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.evenement.evenement_ms.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    @Query("SELECT c FROM Categorie c LEFT JOIN FETCH c.evenements")
    List<Categorie> findAllWithEvenements();
}
