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

import com.examenGuevara.demo.entity.Vuelo;
import com.examenGuevara.demo.service.VueloService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(API_VUELO)
@CrossOrigin(origins = "http://localhost:4200")

public class VueloController {
	
	@Autowired
	private VueloService vueloService;
	
	@GetMapping("/readAll")
	public ResponseEntity<List<Vuelo>> listar() {
		try {
            List<Vuelo> var = vueloService.readAll();
                if (var.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
                return new ResponseEntity<>(var, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
    public ResponseEntity<Vuelo> crear(@Valid @RequestBody Vuelo obj){
        try {
            Vuelo _aut = vueloService.create(obj);
            return new ResponseEntity<Vuelo>(_aut, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Vuelo> listar2(@PathVariable("id") long id) {
		Vuelo lbr = vueloService.read(id);
		if (lbr!=null) {
			return new ResponseEntity<>(lbr, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Vuelo> delete(@PathVariable("id") Long id){
		try {
			vueloService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	@PutMapping("/put/{id}")
	public ResponseEntity<Vuelo> updateTutorial(@PathVariable("id") long id, @RequestBody Vuelo obt) {
		Vuelo db = vueloService.read(id);
		if (db!=null) {
			db.setId(obt.getId());
			db.setFechaSalida(obt.getFechaSalida());
			db.setHoraSalida(obt.getHoraSalida());
			db.setFechaLlegada(obt.getFechaLlegada());
			db.setHoraLlegada(obt.getHoraLlegada());
			db.setOrigen(obt.getOrigen());
			db.setDestino(obt.getDestino());
			db.setNPlazasTotales(obt.getNPlazasTotales());
			//!OneToMany's
			db.setReservas(obt.getReservas());
			return new ResponseEntity<>(vueloService.create(db), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
