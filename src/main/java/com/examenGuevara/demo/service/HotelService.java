package com.examenGuevara.demo.service;

import java.util.List;

import com.examenGuevara.demo.entity.Hotel;

public interface HotelService {
	
	Hotel create(Hotel proy);
	Hotel update(Hotel proy);
	void delete(Long id);
	Hotel read(Long id);
	List<Hotel> readAll();
	
}

