package com.evenement.evenement_ms.scheduler;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.evenement.evenement_ms.repositories.CategorieRepository;

import jakarta.transaction.Transactional;

@Component
public class CategoryLog {

    private static final Logger log = LoggerFactory.getLogger(CategoryLog.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private CategorieRepository categorieRepository;

    @Scheduled(fixedRate = 15000)
    @Transactional
    public void listeEvenementsParCategorie() {

        log.info("Liste des evenements par categorie");
        categorieRepository.findAll().forEach(categorie -> {
            log.info("Categorie: " + categorie.getNomCategorie());
            categorie.getEvenements().forEach(evenement -> {
                log.info("Evenement: " + evenement.getNomEvenement());
            });
        });
    }
}
