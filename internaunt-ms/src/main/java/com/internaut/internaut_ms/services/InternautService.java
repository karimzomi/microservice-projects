package com.internaut.internaut_ms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internaut.internaut_ms.entities.Internaut;
import com.internaut.internaut_ms.repositories.InternautRepository;

@Service
public class InternautService {

    @Autowired
    private InternautRepository InternautRepository;

    public List<Internaut> findAll() {
        return InternautRepository.findAll();
    }

    public Internaut findById(Long id) {
        return InternautRepository.findById(id).orElse(null);
    }

    public Internaut save(Internaut Internaut) {
        return InternautRepository.save(Internaut);
    }

    public void deleteById(Long id) {
        InternautRepository.deleteById(id);
    }

    public Internaut update(Long id, Internaut Internaut) {
        Internaut entity = InternautRepository.findById(id).orElse(null);
        if (entity != null) {
            entity.setIdentifiant(Internaut.getIdentifiant());
            entity.setTrancheAge(Internaut.getTrancheAge());

            return InternautRepository.save(entity);
        }
        return null;
    }

}
