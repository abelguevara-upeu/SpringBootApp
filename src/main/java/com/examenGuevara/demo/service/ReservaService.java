package com.examenGuevara.demo.service;

import java.util.List;

import com.examenGuevara.demo.entity.Reserva;

public interface ReservaService {
	
	Reserva create(Reserva proy);
	Reserva update(Reserva proy);
	void delete(Long id);
	Reserva read(Long id);
	List<Reserva> readAll();
	void reiniciarSecuencia(String tabla, String secuencia, Long idABorrar);

}

