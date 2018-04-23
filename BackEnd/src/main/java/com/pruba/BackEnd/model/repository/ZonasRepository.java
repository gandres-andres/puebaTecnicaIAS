package com.pruba.BackEnd.model.repository;

import com.pruba.BackEnd.model.tont_zonas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonasRepository extends JpaRepository<tont_zonas, String>{
    
}
