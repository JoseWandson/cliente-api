package com.wandson.cliente.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Endereco {

	@NotBlank
	private String logradouro;

	@NotBlank
	private String numero;

	@NotBlank
	private String cep;

	@NotBlank
	private String cidade;

	@NotBlank
	private String estado;

	@NotBlank
	private String pais;

}
