package com.examenGuevara.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examenGuevara.demo.entity.Sucursal;
@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long>{
    
}
