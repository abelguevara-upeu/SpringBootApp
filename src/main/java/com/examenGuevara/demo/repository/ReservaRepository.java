package com.examenGuevara.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examenGuevara.demo.entity.Reserva;
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{
    
}
