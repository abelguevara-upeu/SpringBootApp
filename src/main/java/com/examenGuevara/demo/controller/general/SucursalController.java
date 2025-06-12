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

import com.examenGuevara.demo.entity.Sucursal;
import com.examenGuevara.demo.service.SucursalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(API_SUCURSAL)
@CrossOrigin(origins = "http://localhost:4200")

public class SucursalController {
	
	@Autowired
	private SucursalService sucursalService;
	
	@GetMapping("/readAll")
	public ResponseEntity<List<Sucursal>> listar() {
		try {
            List<Sucursal> var = sucursalService.readAll();
                if (var.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
                return new ResponseEntity<>(var, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
    public ResponseEntity<Sucursal> crear(@Valid @RequestBody Sucursal proyeccion){
        try {
            Sucursal _aut = sucursalService.create(proyeccion);
            return new ResponseEntity<Sucursal>(_aut, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Sucursal> listar2(@PathVariable("id") long id) {
		Sucursal lbr = sucursalService.read(id);
		if (lbr!=null) {
			return new ResponseEntity<>(lbr, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Sucursal> delete(@PathVariable("id") Long id){
		try {
			sucursalService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	@PutMapping("/put/{id}")
	public ResponseEntity<Sucursal> updateTutorial(@PathVariable("id") long id, @RequestBody Sucursal obt) {
		Sucursal db = sucursalService.read(id);
		if (db!=null) {
			db.setId(obt.getId());
			db.setNombreSucursal(obt.getNombreSucursal());
			db.setDireccion(obt.getDireccion());
			db.setLocalidad(obt.getLocalidad());
			db.setProvincia(obt.getProvincia());
			db.setTelefono(obt.getTelefono());
			//!OneToMany's
			db.setReservas(obt.getReservas());
			return new ResponseEntity<>(sucursalService.create(db), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
