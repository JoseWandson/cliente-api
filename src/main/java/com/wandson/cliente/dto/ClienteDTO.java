package com.wandson.cliente.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.wandson.cliente.model.Endereco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

	private Long id;

	@NotBlank
	private String nome;

	@NotBlank
	private String telefone;

	@NotNull
	private Endereco endereco;

}
