package com.examenGuevara.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examenGuevara.demo.entity.Vuelo;
@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long>{
    
}
