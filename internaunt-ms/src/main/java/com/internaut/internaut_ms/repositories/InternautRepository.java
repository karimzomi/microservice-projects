package com.internaut.internaut_ms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internaut.internaut_ms.entities.Internaut;

@Repository
public interface InternautRepository extends JpaRepository<Internaut, Long> {
}