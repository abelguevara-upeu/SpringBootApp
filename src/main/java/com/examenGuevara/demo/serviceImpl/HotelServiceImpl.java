package com.examenGuevara.demo.serviceImpl;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenGuevara.demo.entity.Hotel;
import com.examenGuevara.demo.repository.HotelRepository;
import com.examenGuevara.demo.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel t) {
		return hotelRepository.save(t);
	}

	@Override
	public Hotel update(Hotel t) {
		return hotelRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		hotelRepository.deleteById(id);
		
	}

	@Override
	public Hotel read(Long id) {
		return hotelRepository.findById(id).get();
	}

	@Override
	public List<Hotel> readAll() {
		List<Hotel> libros = hotelRepository.findAll();
        libros.sort(Comparator.comparing(Hotel::getId));
        return libros;
	}

}
