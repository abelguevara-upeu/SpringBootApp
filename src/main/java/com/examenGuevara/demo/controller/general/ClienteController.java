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

import com.examenGuevara.demo.entity.Cliente;
import com.examenGuevara.demo.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(API_CLIENTE)
@CrossOrigin(origins = "http://localhost:4200")

public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/readAll")
	public ResponseEntity<List<Cliente>> listar() {
		try {
            List<Cliente> var = clienteService.readAll();
                if (var.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
                return new ResponseEntity<>(var, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
    public ResponseEntity<Cliente> crear(@Valid @RequestBody Cliente proyeccion){
        try {
            Cliente _aut = clienteService.create(proyeccion);
            return new ResponseEntity<Cliente>(_aut, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Cliente> listar2(@PathVariable("id") long id) {
		Cliente lbr = clienteService.read(id);
		if (lbr!=null) {
			return new ResponseEntity<>(lbr, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Cliente> delete(@PathVariable("id") Long id){
		try {
			clienteService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	@PutMapping("/put/{id}")
	public ResponseEntity<Cliente> updateTutorial(@PathVariable("id") long id, @RequestBody Cliente obt) {
		Cliente db = clienteService.read(id);
		if (db!=null) {
			db.setId(obt.getId());
			db.setNif(obt.getNif());
			db.setNombres(obt.getNombres());
			db.setApellidos(obt.getApellidos());
			db.setTelefono(obt.getTelefono());
			db.setEmail(obt.getEmail());
			//!OneToMany's
			db.setReservas(obt.getReservas());
			return new ResponseEntity<>(clienteService.create(db), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
