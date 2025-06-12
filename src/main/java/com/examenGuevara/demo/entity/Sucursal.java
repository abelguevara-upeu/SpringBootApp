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
@Table(name="SUCURSALES")
public class Sucursal {

	@Id
	@Column(name = "sucursal_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = 0L;

	@NotNull
	@Column(name = "NOMBRE_SUCURSAL")
    private String nombreSucursal;

	@NotNull
	@Column(name = "DIRECCION")
    private String direccion;

	@NotNull
	@Column(name = "LOCALIDAD")
    private String localidad;

	@NotNull
	@Column(name = "PROVINCIA")
    private String provincia;

	@NotNull
	@Column(name = "TELEFONO")
    private String telefono;

	//!OneToMany's
	@OneToMany(											//*Verificado
		mappedBy = "sucursalReferente",
		cascade = CascadeType.ALL,
		fetch = FetchType.LAZY
	)
	@JsonIgnore
	private Set<Reserva> reservas;

}
