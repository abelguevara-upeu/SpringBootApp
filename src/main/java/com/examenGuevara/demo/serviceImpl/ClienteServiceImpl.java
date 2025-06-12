package com.examenGuevara.demo.serviceImpl;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenGuevara.demo.entity.Cliente;
import com.examenGuevara.demo.repository.ClienteRepository;
import com.examenGuevara.demo.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente create(Cliente t) {
		return clienteRepository.save(t);
	}

	@Override
	public Cliente update(Cliente t) {
		return clienteRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		clienteRepository.deleteById(id);
		
	}

	@Override
	public Cliente read(Long id) {
		return clienteRepository.findById(id).get();
	}

	@Override
	public List<Cliente> readAll() {
		List<Cliente> libros = clienteRepository.findAll();
        libros.sort(Comparator.comparing(Cliente::getId));
        return libros;
	}
	
}
