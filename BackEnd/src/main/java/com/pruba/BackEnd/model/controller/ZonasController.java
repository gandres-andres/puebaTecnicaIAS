package com.pruba.BackEnd.model.controller;

import com.pruba.BackEnd.model.exception.ResourceNotFoundException;
import com.pruba.BackEnd.model.repository.ZonasRepository;
import com.pruba.BackEnd.model.tont_aves;
import com.pruba.BackEnd.model.tont_aves_pais;
import com.pruba.BackEnd.model.tont_paises;
import com.pruba.BackEnd.model.tont_zonas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ZonasController {

    @Autowired
    ZonasRepository zonasRepository;

    @PersistenceContext
    private EntityManager entityManager;

    // Get All Aves
    @GetMapping("/zonas")
    public List<tont_zonas> getAllAves() {
        return zonasRepository.findAll();
    }

    // Get ava from zona
    @GetMapping("/zonas/{cdave}")
    public List<tont_aves> getAveByZona(@PathVariable(value = "cdave") String cdzona) {
        tont_zonas zonas = zonasRepository.findById(cdzona)
                .orElseThrow(() -> new ResourceNotFoundException("tont_zonas", "cdzona", cdzona));
        List<tont_aves> aves = new ArrayList<>();
        zonas.getPaises().forEach((pais) -> {
            pais.getAves_pais().forEach((ave) -> {
                if(igual(aves,ave.getTont_aves())){
                    aves.add(ave.getTont_aves());
                }
            });
        });
        return aves;
    }

    public boolean igual(List<tont_aves> aves, tont_aves ave) {
        boolean res = true;
        for (tont_aves a : aves) {
            if (a.getCdave() == ave.getCdave()) {
                res = false;
            }
        }
        return res;
    }
}
