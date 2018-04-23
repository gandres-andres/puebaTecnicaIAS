package com.pruba.BackEnd.model.controller;

import com.pruba.BackEnd.model.exception.ResourceNotFoundException;
import com.pruba.BackEnd.model.tont_aves;
import com.pruba.BackEnd.model.repository.AvesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AvesController {

    @Autowired
    AvesRepository aveRepository;

    // Get All Aves
    @GetMapping("/aves")
    public List<tont_aves> getAllAves() {
        return aveRepository.findAll();
    }

    // Create a new Ave
    @PostMapping("/aves")
    public tont_aves createAve(@Valid @RequestBody tont_aves ave) {
        return aveRepository.save(ave);
    }

    // Get a Single Ave
    @GetMapping("/aves/{cdave}")
    public tont_aves getAveById(@PathVariable(value = "cdave") String cdave) {
        return aveRepository.findById(cdave)
                .orElseThrow(() -> new ResourceNotFoundException("tont_aves", "cdave", cdave));
    }

    // Update a Ave
    @PutMapping("/aves/{cdave}")
    public tont_aves updateAve(@PathVariable(value = "cdave") String cdave,
            @Valid @RequestBody tont_aves aveDetails) {
        tont_aves ave = aveRepository.findById(cdave)
                .orElseThrow(() -> new ResourceNotFoundException("tont_aves", "cdave", cdave));

        ave.setDsnombre_comun(aveDetails.getDsnombre_comun());
        ave.setDsnombre_cientifico(aveDetails.getDsnombre_cientifico());

        tont_aves updatedAve = aveRepository.save(ave);
        return updatedAve;
    }

    // Delete a Ave
    @DeleteMapping("/aves/{cdave}")
    public ResponseEntity<?> deleteAve(@PathVariable(value = "cdave") String cdave) {
        tont_aves ave = aveRepository.findById(cdave)
                .orElseThrow(() -> new ResourceNotFoundException("tont_aves", "cdave", cdave));

        aveRepository.delete(ave);

        return ResponseEntity.ok().build();
    }
    
}
