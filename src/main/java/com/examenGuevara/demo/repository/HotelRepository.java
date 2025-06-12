package com.examenGuevara.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examenGuevara.demo.entity.Hotel;
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{
    
}
