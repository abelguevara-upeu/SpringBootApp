package com.examenGuevara.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examenGuevara.demo.entity.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
