package com.examenGuevara.demo.serviceImpl;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenGuevara.demo.entity.Sucursal;
import com.examenGuevara.demo.repository.SucursalRepository;
import com.examenGuevara.demo.service.SucursalService;

@Service
public class SucursalServiceImpl implements SucursalService{
	
	@Autowired
	private SucursalRepository sucursalRepository;

	@Override
	public Sucursal create(Sucursal t) {
		return sucursalRepository.save(t);
	}

	@Override
	public Sucursal update(Sucursal t) {
		return sucursalRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		sucursalRepository.deleteById(id);
		
	}

	@Override
	public Sucursal read(Long id) {
		return sucursalRepository.findById(id).get();
	}

	@Override
	public List<Sucursal> readAll() {
		List<Sucursal> libros = sucursalRepository.findAll();
        libros.sort(Comparator.comparing(Sucursal::getId));
        return libros;
	}	
}
