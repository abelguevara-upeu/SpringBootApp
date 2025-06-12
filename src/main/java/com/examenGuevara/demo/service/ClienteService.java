package com.examenGuevara.demo.service;

import java.util.List;

import com.examenGuevara.demo.entity.Cliente;

public interface ClienteService{
	
	Cliente create(Cliente proy);
	Cliente update(Cliente proy);
	void delete(Long id);
	Cliente read(Long id);
	List<Cliente> readAll();
	
}

