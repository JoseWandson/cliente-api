package com.wandson.cliente.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

	@NotBlank
	private String nome;

	@Email
	@NotBlank
	private String email;

	@NotBlank
	private String senha;

}
