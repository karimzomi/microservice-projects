package com.evenement.evenement_ms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evenement.evenement_ms.dto.CategorieDTO;
import com.evenement.evenement_ms.dto.EvenementCreateDTO;
import com.evenement.evenement_ms.entities.Categorie;
import com.evenement.evenement_ms.entities.Evenement;
import com.evenement.evenement_ms.services.EvenementService;

@RestController
@RequestMapping("")
public class EvenementController {

    @Autowired
    private EvenementService evenementService;

    @GetMapping("/all")
    public List<Evenement> findAll() {
        return evenementService.findAll();
    }

    @GetMapping("/find")
    public Evenement findById(@RequestParam Long id) {
        return evenementService.findById(id);
    }

    @PostMapping("/save")
    public Evenement save(@RequestBody EvenementCreateDTO evenementDTO) {
        return evenementService.save(evenementDTO);
    }

    @PostMapping("/categorie/save")
    public Categorie save(@RequestBody CategorieDTO categoryDTO) {
        return evenementService.saveCategorie(categoryDTO);
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam Long id) {
        evenementService.deleteById(id);
    }
}