package com.examenGuevara.demo.service;

import java.util.List;

import com.examenGuevara.demo.entity.Vuelo;

public interface VueloService {
	
	Vuelo create(Vuelo proy);
	Vuelo update(Vuelo proy);
	void delete(Long id);
	Vuelo read(Long id);
	List<Vuelo> readAll();

}

