package com.examenGuevara.demo.controller.general;

import static com.examenGuevara.demo.commons.GlobalConstans.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examenGuevara.demo.entity.Hotel;
import com.examenGuevara.demo.service.HotelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(API_HOTEL)
@CrossOrigin(origins = "http://localhost:4200")

public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@GetMapping("/readAll")
	public ResponseEntity<List<Hotel>> listar() {
		try {
            List<Hotel> var = hotelService.readAll();
                if (var.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
                return new ResponseEntity<>(var, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
    public ResponseEntity<Hotel> crear(@Valid @RequestBody Hotel obj){
        try {
            Hotel _aut = hotelService.create(obj);
            return new ResponseEntity<Hotel>(_aut, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Hotel> listar2(@PathVariable("id") long id) {
		Hotel lbr = hotelService.read(id);
		if (lbr!=null) {
			return new ResponseEntity<>(lbr, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Hotel> delete(@PathVariable("id") Long id){
		try {
			hotelService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	@PutMapping("/put/{id}")
	public ResponseEntity<Hotel> updateTutorial(@PathVariable("id") long id, @RequestBody Hotel obt) {
		Hotel db = hotelService.read(id);
		if (db!=null) {
			db.setId(obt.getId());
			db.setNombreHotel(obt.getNombreHotel());
			db.setDireccion(obt.getDireccion());
			db.setLocalidad(obt.getLocalidad());
			db.setProvincia(obt.getProvincia());
			db.setTelefono(obt.getTelefono());
			db.setNumeroEstrellas(obt.getNumeroEstrellas());
			//!OneToMany's
			db.setReservas(obt.getReservas());
			return new ResponseEntity<>(hotelService.create(db), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
