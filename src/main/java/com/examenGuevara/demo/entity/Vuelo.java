//Completo
package com.examenGuevara.demo.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="VUELOS")
public class Vuelo {

	@Id
	@Column(name = "vuelo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

	@NotNull
	@Column(name = "FECHA_SALIDA")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yy", timezone = "UTC")
    private String fechaSalida;

	@NotNull
	@Column(name = "HORA_SALIDA")
    private String horaSalida;

	@NotNull
	@Column(name = "FECHA_LLEGADA")
    private String fechaLlegada;

	@NotNull
	@Column(name = "HORA_LLEGADA")
    private String horaLlegada;

	@NotNull
	@Column(name = "ORIGEN")
    private String origen;

	@NotNull
	@Column(name = "DESTINO")
    private String destino;

	@NotNull
	@Column(name = "NUMERO_PLAZAS_TOTALES")
    private int nPlazasTotales;

	//!OneToMany's
	@OneToMany(											//*Verificado
		mappedBy = "vueloReferente",
		cascade = CascadeType.ALL,
		fetch = FetchType.LAZY
	)
	@JsonIgnore
	private Set<Reserva> reservas;

}
