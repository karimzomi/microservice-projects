package com.internaut.internaut_ms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.internaut.internaut_ms.dto.InternautDTO;
import com.internaut.internaut_ms.entities.Internaut;
import com.internaut.internaut_ms.services.InternautService;

@RestController
@RequestMapping("")
public class InternautController {

    @Autowired
    private InternautService InternautService;

    @GetMapping("/all")
    public List<Internaut> findAll() {
        return InternautService.findAll();
    }

    @GetMapping("/find")
    public Internaut findById(@RequestParam Long id) {
        return InternautService.findById(id);
    }

    @PostMapping("/save")
    public Internaut save(@RequestBody InternautDTO internautDTO) {
        Internaut internaut = Internaut.builder().identifiant(internautDTO.getIdentifiant())
                .trancheAge(internautDTO.getTrancheAge()).idInternaut(internautDTO.getIdInternaut()).build();
        return InternautService.save(internaut);
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam Long id) {
        InternautService.deleteById(id);
    }
}