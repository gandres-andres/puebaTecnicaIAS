package com.pruba.BackEnd.model.repository;

import com.pruba.BackEnd.model.tont_aves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvesRepository extends JpaRepository<tont_aves, String>{
    
}
