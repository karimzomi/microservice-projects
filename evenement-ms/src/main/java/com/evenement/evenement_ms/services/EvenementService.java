package com.evenement.evenement_ms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evenement.evenement_ms.dto.CategorieDTO;
import com.evenement.evenement_ms.dto.EvenementCreateDTO;
import com.evenement.evenement_ms.entities.Categorie;
import com.evenement.evenement_ms.entities.Evenement;
import com.evenement.evenement_ms.repositories.CategorieRepository;
import com.evenement.evenement_ms.repositories.EvenementRepository;

@Service
public class EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    public List<Evenement> findAll() {
        return evenementRepository.findAll();
    }

    public Evenement findById(Long id) {
        return evenementRepository.findById(id).orElse(null);
    }

    public Evenement save(EvenementCreateDTO evenementDTO) {
        Evenement event = Evenement.builder()
                .nomEvenement(evenementDTO.getNomEvenement())
                .nbPlaces(evenementDTO.getNbPlaces())
                .dateEvenement(evenementDTO.getDateEvenement())
                .build();

        if (event.getCategories() == null) {
            event.setCategories(new ArrayList<>());
        }

        evenementDTO.getCategories().forEach(id -> {
            Categorie cat = categorieRepository.findById(id).orElse(null);
            if (cat != null) {
                event.getCategories().add(cat);
            }
        });

        return evenementRepository.save(event);
    }

    public Categorie saveCategorie(CategorieDTO categorieDTO) {
        Categorie cat = Categorie.builder().codeCategorie(categorieDTO.getCodeCategorie())
                .nomCategorie(categorieDTO.getNomCategorie())
                .build();
        return categorieRepository.save(cat);
    }

    public void deleteById(Long id) {
        evenementRepository.deleteById(id);
    }

    public Evenement update(Long id, Evenement Evenement) {
        Evenement entity = evenementRepository.findById(id).orElse(null);
        if (entity != null) {
            entity.setNomEvenement(Evenement.getNomEvenement());
            entity.setNbPlaces(Evenement.getNbPlaces());
            entity.setDateEvenement(Evenement.getDateEvenement());
            return evenementRepository.save(entity);
        }
        return null;
    }

}
