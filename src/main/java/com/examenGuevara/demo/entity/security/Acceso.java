package com.examenGuevara.demo.entity.security;


import java.sql.Blob;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
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
@Table(name="ACCESOS")
public class Acceso {


	@Id
	@Column(name = "acceso_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Builder.Default
	private Long id = 0L;

	@NotNull
	@Column(name = "ACCESO")
    private String acceso;

	@Null
	@Column(name = "IMG")
    private Blob img;

	@NotNull
	@Column(name = "URL")
    private String url;

	@NotNull
	@Column(name = "ESTADO")
	private int	estado;

	//!ManyToOne's

	@ManyToOne(fetch = FetchType.LAZY)					//*Verificado
    @JoinColumn(name = "SUBACCESO_ID", nullable = true)
    private Acceso subAcceso;

	//!OneToMany 's

	@OneToMany(											//*Verificado
		mappedBy = "acceso",
		cascade = CascadeType.ALL,
		fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<AccesoUsuario> accesosUsuarios;

	@OneToMany(											//*Verificado
		mappedBy = "accesoAsociado",
		cascade = CascadeType.ALL,
		fetch = FetchType.LAZY
	)
	@JsonIgnore
	private Set<RolAcceso> rolesAccesos;

}
