package com.examenGuevara.demo.service;

import java.util.List;

import com.examenGuevara.demo.entity.Sucursal;

public interface SucursalService {
	
	Sucursal create(Sucursal proy);
	Sucursal update(Sucursal proy);
	void delete(Long id);
	Sucursal read(Long id);
	List<Sucursal> readAll();

}

