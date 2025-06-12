package com.examenGuevara.demo.serviceImpl;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenGuevara.demo.entity.Vuelo;
import com.examenGuevara.demo.repository.VueloRepository;
import com.examenGuevara.demo.service.VueloService;

@Service
public class VueloServiceImpl implements VueloService{
	
	@Autowired
	private VueloRepository vueloRepository;

	@Override
	public Vuelo create(Vuelo t) {
		return vueloRepository.save(t);
	}

	@Override
	public Vuelo update(Vuelo t) {
		return vueloRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		vueloRepository.deleteById(id);
		
	}

	@Override
	public Vuelo read(Long id) {
		return vueloRepository.findById(id).get();
	}

	@Override
	public List<Vuelo> readAll() {
		List<Vuelo> libros = vueloRepository.findAll();
        libros.sort(Comparator.comparing(Vuelo::getId));
        return libros;
	}

}
