//Completo
package com.examenGuevara.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="RESERVAS")
public class Reserva {

    @Id
    @Column(name = "reserva_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Builder.Default
    private Long id = 0L;

	@NotNull
	@Column(name = "CLASE")
    private String clase;

	// //!ManyToOne's

	@ManyToOne											//*Verificado
	@JoinColumn(name = "VUELO_ID", nullable = false)
    private Vuelo vueloReferente;

	@ManyToOne											//*Verificado
	@JoinColumn(name = "CLIENTE_ID", nullable = false)
    private Cliente clienteReferente;

	@ManyToOne											//*Verificado
	@JoinColumn(name = "HOTEL_ID", nullable = false)
    private Hotel hotelReferente;

	@ManyToOne											//*Verificado
	@JoinColumn(name = "SUCURSAL_ID", nullable = false)
    private Sucursal sucursalReferente;

}
