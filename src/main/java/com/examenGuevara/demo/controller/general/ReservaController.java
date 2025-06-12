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

import com.examenGuevara.demo.entity.Reserva;
import com.examenGuevara.demo.service.ReservaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(API_RESERVA)
@CrossOrigin(origins = "http://localhost:4200")

public class ReservaController {
	
	@Autowired
	private ReservaService reservaService;
	
	@GetMapping("/readAll")
	public ResponseEntity<List<Reserva>> listar() {
		try {
            List<Reserva> var = reservaService.readAll();
                if (var.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
                return new ResponseEntity<>(var, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
    public ResponseEntity<Reserva> crear(@Valid @RequestBody Reserva obj){
        try {
            Reserva _aut = reservaService.create(obj);
            return new ResponseEntity<Reserva>(_aut, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Reserva> listar2(@PathVariable("id") long id) {
		Reserva lbr = reservaService.read(id);
		if (lbr!=null) {
			return new ResponseEntity<>(lbr, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Reserva> delete(@PathVariable("id") Long id){
		try {
			reservaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	@PutMapping("/put/{id}")
	public ResponseEntity<Reserva> updateTutorial(@PathVariable("id") long id, @RequestBody Reserva obt) {
		Reserva db = reservaService.read(id);
		if (db!=null) {
			db.setId(obt.getId());
			db.setClase(obt.getClase());
			//!ManyToOne's
			db.setVueloReferente(obt.getVueloReferente());
			db.setClienteReferente(obt.getClienteReferente());
			db.setHotelReferente(obt.getHotelReferente());
			db.setSucursalReferente(obt.getSucursalReferente());
			return new ResponseEntity<>(reservaService.create(db), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
